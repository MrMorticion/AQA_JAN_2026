package org.prog.session6;

public class Calc {

    public static int add(int a, int b) {
        if (a > b) {
            return a + b;
        }
        return a + b;
    }

    public static String concat(String a, String b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int countTo(int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(j);
            if (j == 50) {
                return -999;
            }
        }
        return i + 1000;
    }

    public static void countFromTo(int from, int to) {
        for (int i = from; i < to; i++) {
            System.out.println(i);
            if (i == 50) {
                return;
            }
        }
    }
}
