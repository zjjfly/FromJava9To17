package com.github.zjjfly;

/**
 *
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date ss
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
