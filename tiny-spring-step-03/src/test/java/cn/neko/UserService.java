package cn.neko;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 16:19
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void query () {
        System.out.println(" query information : " + name);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("");
        builder.append("").append(name);
        return builder.toString();
    }
}
