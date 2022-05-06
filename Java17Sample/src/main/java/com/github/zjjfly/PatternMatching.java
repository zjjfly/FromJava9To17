package com.github.zjjfly;

/**
 * 模式匹配
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/5/6
 */
public class PatternMatching {

    public static void main(String[] args) {
        //Java16正式引入了instanceof的模式匹配，避免了显式的类型强制转换
        Object obj = "Hello,World";

        //下面代码在s称为模式参数，如果模式匹配右边还有其它使用&&相连的条件，这些条件表达式也可以访问到模式参数
        if (obj instanceof String s && s.length() > 5) {
            System.out.println("string length: " + s.length());
        }

        //Java17把模式匹配加入了switch,目前是preview版本
        //需要在编译和运行的时候加上参数--enable-preview
        Object inputObject = 500L;
        String formattedObject = switch (inputObject) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> inputObject.toString();
        };
        System.out.println("formattedObject = " + formattedObject);
    }

}
