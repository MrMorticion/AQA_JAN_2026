package org.prog.session3;

//TODO: Write bubble sort
//TODO: Fill array with random numbers *

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        //4,1,8,5,8,0,12,9
        //1,4,5,8,0,8,9,12
        //1,4,5,0,8,8,9,12
        //1,4,0,5,8,8,9,12
        //1,0,4,5,8,8,9,12
        //0,1,4,5,8,8,9,12
        //0,1,4,5,8,8,9,12 < DONE
        Random random = new Random();
        int[] myArrayToSort = new int[100];
        for (int i = 0; i < myArrayToSort.length; i++) {
            myArrayToSort[i] = random.nextInt(1000);
            System.out.println(myArrayToSort[i]);
        }
        System.out.println("===============================================");
        boolean condition = true;

        do {
            condition = false;
            for (int i = 0; i < myArrayToSort.length - 1; i++) {
                if (myArrayToSort[i] > myArrayToSort[i + 1]) {
                    int current = myArrayToSort[i];
                    myArrayToSort[i] = myArrayToSort[i + 1];
                    myArrayToSort[i + 1] = current;
                    condition = true;
                }
            }
        } while (condition);

        for (int i = 0; i < myArrayToSort.length; i++) {
            System.out.println(myArrayToSort[i]);
        }
    }
}
