package com.github.zjjfly;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.random.RandomGenerator;

/**
 * 一些较小的调整的集合
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/5/6
 */
public class MinorFeatures {

    public static void main(String[] args) throws IOException {
        //Java11中，Files添加读取文件内容为String的方法
        String content = Files.readString(Path.of("pom.xml"));
        System.out.println("pom.xml: " + content);

        //Java14改善了NullPointException的错误信息，说明了哪个对象是null
        try{
            String professor = null;
            System.out.println(professor.length());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            //Cannot invoke "String.length()" because "professor" is null
        }

        // Java17恢复了默认使用严格浮点数，之前的版本需要使用strictfp关键字显式声明
        record Sum(double a, double b) {

            public double get() {
                return a + b;
            }

        }
        Sum sum = new Sum(1.2, 3.2);
        System.out.println("sum.get() = " + sum.get());

        //Java17加入了新的生成随机数的接口RandomGenerator,这样可以把API和具体实现分开，并且不改变现有的Random类
        RandomGenerator randomGenerator = RandomGenerator.of("L64X1024MixRandom");
        System.out.println("nextBoolean = " + randomGenerator.nextBoolean());
        System.out.println("nextDouble = " + randomGenerator.nextDouble());
        System.out.println("nextInt = " + randomGenerator.nextInt());
        System.out.println("nextLong = " + randomGenerator.nextLong());
    }

}
