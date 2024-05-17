package org.springframework;

/**
 * @Author: LiYunxiao
 * @Date: 2024-05-17-22:27
 * @Description:
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
