package in.strikes.servlet;

import in.strikes.Service.Userservice;
import in.strikes.model.user;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private Userservice userservice = new Userservice();

    @Override
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (name == null || idParam == null || email == null || mobile == null){
             response.setStatus(400);
             response.setContentType("application/json");
             response.getWriter().write("    {\n" +
                     "        \"message\" : \"some feilds are missing!\"\n" +
                     "    }");
             return;
        }

        Integer id = Integer.parseInt(idParam);
        user user = new user(id,name,email,mobile);
        user u1 = userservice.create(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("    {\n" +
                "        \"message\" : \"user added succesfully\"\n" +
                "    }");

    }

    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {

        String IdParam = request.getParameter("id");

        if (IdParam == null){
            //get all
            List<user> uall = Userservice.getAllUser();

            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(userstojson(uall));
        }

        else{
            //get one
            Integer OId = Integer.parseInt(IdParam);
            user user = Userservice.getBYId(OId);

            if (user == null){
                response.setStatus(404);
                response.setContentType("application/json");
                response.getWriter().write("    {\n" +
                        "        \"message\" : \"user not found!\"\n" +
                        "    }");
                return;
            }

            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usertojson(user));

        }

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (idParam == null || name == null || email == null || mobile == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("    {\n" +
                    "        \"message\" : \"some feilds are missing!\"\n" +
                    "    }");
            return;
        }

        Integer id = Integer.parseInt(idParam);
        user existingUser = Userservice.getBYId(id);

        if (existingUser == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("    {\n" +
                    "        \"message\" : \"user not found!\"\n" +
                    "    }");
            return;
        }

        user user = new user(id, name, email, mobile);
        userservice.update(user);

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write("    {\n" +
                "        \"message\" : \"user updated succesfully\"\n" +
                "    }");

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        if (idParam == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("    {\n" +
                    "        \"message\" : \"id parameter is missing!\"\n" +
                    "    }");
            return;
        }

        Integer id = Integer.parseInt(idParam);
        user user = Userservice.getBYId(id);

        if (user == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("    {\n" +
                    "        \"message\" : \"user not found!\"\n" +
                    "    }");
            return;
        }

        userservice.delete(id);

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write("    {\n" +
                "        \"message\" : \"user deleted succesfully\"\n" +
                "    }");

    }

    private String usertojson(user user){

        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\": \"" + user.getName() + "\",\n" +
                "    \"mobile\": \"" + user.getMobile() + "\",\n" +
                "    \"email\": \"" + user.getEmail() + " \"\n" +
                "}";
    }

    private String userstojson(List<user> users){

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i =0 ; i < users.size() ; i++){

            sb.append(usertojson(users.get(i)));

            if (i < users.size() - 1){
                sb.append(",");
            }

        }

        sb.append("]");

        return sb.toString();
    }

}





