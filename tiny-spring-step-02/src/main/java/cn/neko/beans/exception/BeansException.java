package cn.neko.beans.exception;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 16:34
 */
public class BeansException extends Exception {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
