package com.github.zjjfly;

/**
 * Java17正式加入了sealed class，<b>sealed class的子类必须是final,sealed或者non-sealed修饰的</b>
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/5/6
 */
public class SealedClass {

    public sealed class LineShape permits Rectangle, Square, Triangle {}

    public final class Rectangle extends LineShape {}

    public non-sealed class Triangle extends LineShape {}

    public sealed class Square extends LineShape permits ColorSquare {}

    public final class ColorSquare extends Square {}

}
