package com.github.zjjfly;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

/**
 * Java17加入了专门用于向量计算的API,它会利用部分硬件支持的向量指令，
 * 需要在编译和运行的时候加上参数--add-modules jdk.incubator.vector
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/5/6
 */
public class VectorComputing {

    static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

    static void vectorSumInt(int[] arrayOne, int[] arrayTwo, int[] s) {
        int i = 0;
        int upperBound = SPECIES.loopBound(arrayOne.length);
        for (; i < upperBound; i += SPECIES.length()) {
            var vIntaOne = IntVector.fromArray(SPECIES,
                arrayOne, i);
            var vIntaTwo = IntVector.fromArray(SPECIES,
                arrayTwo, i);
            var vs = vIntaOne.add(vIntaTwo);
            vs.intoArray(s, i);
        }
        for (; i < arrayOne.length; i++) {
            s[i] = (arrayOne[i] + arrayTwo[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 4, 10};
        int[] b = {5, 6, 7, 8, 9};
        int[] c = {0, 0, 0, 0, 0};
        VectorComputing.vectorSumInt(a, b, c);
        for (int j : c) {
            System.out.println(j);
        }
    }

}
