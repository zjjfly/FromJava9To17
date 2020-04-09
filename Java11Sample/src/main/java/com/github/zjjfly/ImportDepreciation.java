package com.github.zjjfly;


//只是导入但不使用是不会发出警告的

/**
 * @author z00405ze
 */

//@Deprecated
//@SuppressWarnings("deprecation")
public class ImportDepreciation extends DeprecationUsed {
    //@Deprecated
    //@SuppressWarnings("deprecation")
    public void doSomething() {
        DeprecatedClass.doSomething();
    }

    @Override
    public boolean weakCAS(int expectedValue, int newValue) {
        //产生过时警告的代码在父类中,不会产生警告
        return super.weakCAS(expectedValue, newValue);
    }

}
