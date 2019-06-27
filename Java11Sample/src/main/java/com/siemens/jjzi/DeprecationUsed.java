package com.siemens.jjzi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author z00405ze
 */
public class DeprecationUsed extends AtomicInteger {

    public boolean weakCAS(int expectedValue, int newValue) {
        return super.weakCompareAndSet(expectedValue, newValue);
    }
}
