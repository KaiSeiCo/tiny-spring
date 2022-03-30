package cn.neko;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 20:57
 */
public class UserDao {

    public static Map<String, String> mp = new HashMap<>();

    static {
        mp.put("10001", "Alice");
        mp.put("10002", "Bob");
        mp.put("10003", "Chen");
    }

    public String queryUserName(String uId) {
        return mp.get(uId);
    }
}
