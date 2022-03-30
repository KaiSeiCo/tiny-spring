package cn.neko;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 20:59
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println(" query information : " + userDao.queryUserName(uId));
    }
}
