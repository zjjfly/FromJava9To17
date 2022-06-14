package com.github.zjjfly;

/**
 * @author z00405ze
 */
public class NewStringMethod {
    public static void main(String[] args) {
        // 判断字符串是否为空白
        System.out.println(" ".isBlank());
        // 去除首尾空格
        char c = '\u2000';
        String s = c + "abc" + c;
        System.out.println(s.strip());
        System.out.println(s.trim());
        // 去除尾部空格
        System.out.println(" java ".stripTrailing());
        // 去除首部空格
        System.out.println(" java ".stripLeading());
        // 复制字符串
        System.out.println("java".repeat(3));
        // 行数统计
        System.out.println("A\nB\nC".lines().count());
    }
}
