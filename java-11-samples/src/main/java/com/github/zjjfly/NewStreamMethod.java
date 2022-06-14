package com.github.zjjfly;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author z00405ze
 */
public class NewStreamMethod {
    public static void main(String[] args) {
        long count = Stream.ofNullable(null).count();
        System.out.println(count);
        List<Integer> lessThan4 = Stream.of(1, 2, 3, 4, 5).takeWhile(i -> i < 4).collect(Collectors.toList());
        System.out.println(lessThan4);
        List<Integer> largerThan3 = Stream.of(1, 2, 3, 4, 5).dropWhile(i -> i < 4).collect(Collectors.toList());
        System.out.println(largerThan3);
        List<Integer> lessThan100 = Stream.iterate(1, i -> i < 100, i -> i + 1).collect(Collectors.toList());
        System.out.println(lessThan100);
    }
}
