package com.siemens.jjzi;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author z00405ze
 */
public class Process {
    public static void main(String[] args) throws InterruptedException, IOException {
        //shutdown hook不一定会被调用
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Stop")));
        java.lang.Process exec = Runtime.getRuntime().exec("bash -c ls");
        InputStream inputStream = exec.getInputStream();
        byte[] bytes=new byte[1024];
        int i;
        while ((i=inputStream.read(bytes))>0){
            System.out.println(new String(bytes, 0, i, StandardCharsets.UTF_8));
        }
        exec.waitFor();
    }
}
