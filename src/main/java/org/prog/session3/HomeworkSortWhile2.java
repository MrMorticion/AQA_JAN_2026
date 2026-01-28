package org.prog.session3;

import java.util.Random;

public class HomeworkSortWhile2 {
    public static void main(String[] args) {

        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
            System.out.println("Число: " + array[i]);
        }

        int i = 0;
        while (i < array.length) {
            if (i != 0 && array[i] < array[i - 1]) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            } else {
                i++;
            }
        }

        System.out.println("\nSort:");
        for (int n : array) {
            System.out.print(n + " ");
        }
    }
}
