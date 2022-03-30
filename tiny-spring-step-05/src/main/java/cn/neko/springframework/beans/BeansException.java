package cn.neko.springframework.beans;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:02
 */
public class BeansException extends Exception {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
