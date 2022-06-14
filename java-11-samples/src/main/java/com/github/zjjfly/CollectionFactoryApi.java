package com.github.zjjfly;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author z00405ze
 */
public class CollectionFactoryApi {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(list.getClass());
        Map<Integer, String> map = Map.of(1, "one", 2, "two");
        System.out.println(map.getClass());
        Set<String> set = Set.of("a", "b", "c");
        System.out.println(set.getClass());
        //这些工厂方法生成的对象都是不可变集合,所以无法对它们内部元素进行修改或排序
        //list.sort(Comparator.reverseOrder());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        //拷贝集合
        List<String> copy = List.copyOf(strings);
        System.out.println(copy);
        System.out.println(copy.getClass());
    }
}
