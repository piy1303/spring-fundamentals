package in.strikes.Service;

import in.strikes.model.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Userservice {

    private static Map<Integer,user> userdb = new HashMap<>();


    public Userservice() {
        if (userdb == null) {
            userdb = new HashMap<>();
        }
    }


//------------------------------------------------

    public user create(user UserReq) {

        userdb.put(UserReq.getId(),UserReq);
        return  UserReq;
    }


    public static user getBYId(Integer oId) {
        return userdb.get(oId);
    }

    public static List<user> getAllUser() {
        return new java.util.ArrayList<>(userdb.values());
    }

    public user update(user userReq) {
        userdb.put(userReq.getId(), userReq);
        return userReq;
    }

    public user delete(Integer id) {
        return userdb.remove(id);
    }

    public static user deleteById(Integer id) {
        return userdb.remove(id);
    }



}
