package cn.neko.springframework.core.io;

import java.io.*;

/**
 * 通过指定文件路径的方式读取文件信息
 * @Author: Elaina
 * @Date: 2022/3/14 15:03
 */
public class FileSystemResource implements Resource {
    private final File file;

    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return this.path;
    }
}
