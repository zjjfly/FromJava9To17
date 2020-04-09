package com.github.zjjfly;

import java.util.Scanner;

public interface PrivateDefaultMethod {
    public default void walk() {
        characterTravel("walk");
    }

    public default void run() {
        characterTravel("run");
    }

    public default void fastWalk() {
        characterTravel("fastWalk");
    }

    public default void retreat() {
        characterTravel("retreat");
    }

    public default void fastRetreat() {
        characterTravel("fastRetreat");
    }

    private void characterTravel(String pace) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired pacing: ");
        int p = scanner.nextInt();
        switch (pace) {
            case "walk":
                p = p + 1;
                break;
            case "run":
                p = p + 4;
                break;
            case "fastWalk":
                p = p + 2;
                break;
            case "retreat":
                p = p - 1;
                break;
            case "fastRetreat":
                p = p - 4;
                break;
            default:
                break;
        }
        System.out.println(p);
    }
}
