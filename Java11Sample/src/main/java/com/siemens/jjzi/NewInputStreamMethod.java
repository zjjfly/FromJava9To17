package com.siemens.jjzi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author z00405ze
 */
public class NewInputStreamMethod {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("build.gradle");
        var build = new File("build.txt");
        try (var outputStream = new FileOutputStream(build)) {
            fileInputStream.transferTo(outputStream);
        }
        System.out.println();
    }
}
