package org.prog.session3;

public class HwSoftFor {
    public static void main(String[] args) {

    int[] array = new int[]{
            4,
            2,
            6,
            8,
            9,
            1,
            10
    };
    for (int i = 0; i < array.length; ) {
        if (i != 0 && array[i] < array[i - 1]) {
            int current = array[i];
            array[i] = array[i - 1];
            array[i - 1] = current;
            i--;
        } else {
            i++;
        }
    }
}
}

