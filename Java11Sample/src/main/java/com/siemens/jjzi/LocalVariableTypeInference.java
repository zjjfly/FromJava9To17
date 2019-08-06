package com.siemens.jjzi;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author z00405ze
 */
public class LocalVariableTypeInference {
    public static void main(String[] args) {
        var str = "Hello";
        System.out.println("str:" + str);
        //不能使用var的情况
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
        System.out.print("numbers:");
        for (var nr : numbers) {
            System.out.print(nr + " ");
        }
        System.out.println();
        numbers = new ArrayList<>() {{
            add("a");
            add("bc");
            add("d");
            add(null);
        }};
        Comparator<String> comparator = (@NotNull var s1, @NotNull var s2) -> s1.length() - s2.length();
        numbers.sort(comparator);
        System.out.println("sorted numbers:" + numbers);
        var divResult = 5 / 2;
        System.out.println("divResult:" + divResult);
        var mulResult = 2.5 * 3;
        System.out.println(mulResult);

        var obj1 = new Child();
        obj1.whistle();
        obj1.stand(); // type of obj inferred as Child

        var obj2 = getObject("Child");
        obj2.whistle();
        //obj2.stand(); // This line doesn't compile

        var obj3 = new Dog();
        obj3.bite();
        obj3.run();

        var obj4 = getObject();
        obj4.run();
        //obj4.bite(); // This line doesn't compile

        char[] name = {'S', 't', 'r', 'i', 'n', 'g'};
        //var name={'S','t','r','i','n','g'}; // This line doesn't compile
        //var[] name = {'S', 't', 'r', 'i', 'n', 'g'}; // This line doesn't compile
        //var name[] = {'S', 't', 'r', 'i', 'n', 'g'}; // This line doesn't compile
        var chars = new char[]{'S', 't', 'r', 'i', 'n', 'g'};
    }

    private static Parent getObject(String type) {
        if (type.equals("Parent")) {
            return new Parent();
        } else {
            return new Child();
        }
    }

    static class Parent {
        void whistle() {
            System.out.println("Parent-Whistle");
        }
    }

    static class Child extends Parent {
        @Override
        void whistle() {
            System.out.println("Child-Whistle");
        }

        void stand() {
            System.out.println("Child-stand");
        }
    }

    interface MarathonRunner {
        default void run() {
            System.out.println("I'm a marathon runner");
        }
    }

    static class Dog implements MarathonRunner {
        void bite() {
            System.out.println("Wang!");
        }
    }

    private static MarathonRunner getObject() {
        return new Dog();
    }

}
