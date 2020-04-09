package com.github.zjjfly;

import java.awt.*;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @author z00405ze
 */
public class VarHandleFoo {
    private static final VarHandle QA;//for arrays
    private static final VarHandle X;//for Variables

    static {
        try {
            QA = MethodHandles.arrayElementVarHandle(Point[].class);
            X = MethodHandles.lookup().findVarHandle(VarHandleFoo.class, "x", int.class);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    volatile int x;
    private Point[] points;

    public VarHandleFoo(Point[] points) {
        this.points = points;
    }

    public static void main(String[] args) throws InterruptedException {
        Point[] points = new Point[100];
        for (int i = 0; i < 100; i++) {
            points[i] = new Point(i, i);
        }
        VarHandleFoo foo = new VarHandleFoo(points);

        //plain read
        System.out.println("init:");
        Object x = X.get(foo);
        System.out.println("x:" + x);
        Point p = (Point) QA.get(points, 10);
        System.out.println("point[10]:" + p);
        System.out.println();

        //plain write
        System.out.println("changed:");
        X.set(foo, 1);
        System.out.println("x:" + X.get(foo));
        Point target = new Point(0, 0);
        QA.set(points, 10, target);
        p = (Point) QA.get(points, 10);
        System.out.println("point[10]:" + p);
        System.out.println();

        //CAS
        System.out.println("compare and set:");
        X.compareAndSet(foo, 1, 2);
        System.out.println("x:" + X.get(foo));
        QA.compareAndSet(points, 10, p, new Point(1, 0));
        p = (Point) QA.get(points, 10);
        System.out.println("point[10]:" + p);
        System.out.println();

        //Numeric Atomic Update
        System.out.println("numeric atomic Update:");
        X.getAndAdd(foo, 10);
        System.out.println("x:" + X.get(foo));

    }

    public void add2X(int x) {
        X.set(this, (Integer) X.get(this) + x);
    }

    public void addToX(int x) {
        X.getAndAdd(this, x);
    }

}
