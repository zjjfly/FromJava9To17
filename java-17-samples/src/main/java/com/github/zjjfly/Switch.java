package com.github.zjjfly;

/**
 * switch可以作为表达式使用，可以有返回值，并且匹配成功后不需要用break关键词退出
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/5/6
 */
public class Switch {

    public static void main(String[] args) {
        var i = switch (args[0]) {
            case "a" -> 1;
            case "b" -> 2;
            default -> 0;
        };
        System.out.println("i = " + i);
    }

}
