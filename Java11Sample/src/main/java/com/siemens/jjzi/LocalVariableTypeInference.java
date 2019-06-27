package com.siemens.jjzi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author z00405ze
 */
public class LocalVariableTypeInference {
    public static void main(String[] args) {
        var str = "Hello";
        System.out.println(str);
        //没有初始化
//        var list;
        //多个变量
//        var a,b=1;
        //数组字面量
//        var array={1,2,3};
        //lambda和方法引用
//        var addOne = a -> a + 1;
//        var sqrt = Math::sqrt;
        var numbers = List.of("a", "bc", "d");
        for (var nr : numbers) {
            System.out.print(nr + " ");
        }
        System.out.println();
        numbers = new ArrayList<>() {{
            add("a");
            add("bc");
            add("d");
        }};
        numbers.sort((var s1, var s2) -> s1.length() - s2.length());
        System.out.println(numbers);
    }
}
