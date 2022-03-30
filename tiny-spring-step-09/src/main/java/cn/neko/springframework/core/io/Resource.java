package cn.neko.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:03
 */
public interface Resource {

    /**
     * 获取 InputStream 流的方法
     * @return
     */
    InputStream getInputStream() throws IOException;
}
