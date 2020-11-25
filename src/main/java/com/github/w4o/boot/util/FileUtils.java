package com.github.w4o.boot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author frank
 * @date 2020/4/21
 */
public class FileUtils {

    /**
     * 文件读取
     *
     * @param file {@link File}
     * @return 文件内容
     * @throws IOException 文件读取异常
     */
    public static String read(File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();

        return buffer.toString();
    }

    /**
     * 读取文件
     *
     * @param fileName 文件名(pathname)
     * @return 文件内容
     * @throws IOException 文件读取异常
     */
    public static String read(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }
        return read(file);
    }
}
