package in.strikes.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**************************************************************************************/

//this file is just to understand lifecycle of servlet like init(),service(),destroy()

/**************************************************************************************/

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("HelloServlet Constructor called");
    }

    @Override
    public void init() {
        System.out.println("init() method called");
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        response.setStatus(200);
        response.setContentType("text/plain");
        response.getWriter().write("Hello");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method called");
    }
}