package com.github.zjjfly;

/**
 * Java16正式引入了record class，类似scala的case class，但其中的字段默认是不可变的
 * <p>它会添加一个默认的构造方法，以及访问其字段的方法和toString,equals,hasCode方法</p>
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/5/6
 */
public class RecordClass {

    public static void main(String[] args) {
        record Person(String name, int age) {
            //可以使用下面的语法给默认的构造函数加一些额外的逻辑
            Person {
                if (age < 0) {
                    throw new IllegalArgumentException("age must be greater than zero!");
                }
            }
        }
        Person person = new Person("foo", 32);
        System.out.println("person = " + person);
        System.out.println("person.name() = " + person.name());
        System.out.println("person.age() = " + person.age());
    }

}
