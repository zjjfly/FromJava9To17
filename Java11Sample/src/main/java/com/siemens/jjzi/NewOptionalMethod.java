package com.siemens.jjzi;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author z00405ze
 */
public class NewOptionalMethod {
    public static void main(String[] args) {
        boolean isEmpty = Optional.of("1").isEmpty();
        System.out.println(isEmpty);
        Optional.<String>empty().ifPresentOrElse(System.out::println,() -> {
            System.out.println("no string");
        });
        Optional<String> or = Optional.<String>empty().or(() -> Optional.of("1"));
        System.out.println(or);
        List<Integer> list = Optional.of(1).stream().collect(Collectors.toList());
        System.out.println(list);
        String s = Optional.<String>empty().orElseThrow();
        System.out.println(s);
    }
}
