package org.prog.session13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class JUnitTestsHW {

    private Random random = new Random();
    private AppleHW apple = new AppleHW();

    class AppleHW {
        int modelNumber = random.nextInt(5) + 1;
    }

    @Test
    public void test1() {
        int i = random.nextInt(100);
        Assertions.assertTrue(i >= 70);
        System.out.println("==== TEST 1 ====");
    }

    @Test
    public void test2() {
        int i = random.nextInt(100);
        Assertions.assertTrue(i >= 70);
        System.out.println("==== TEST 2 ====");
    }

    @Test
    public void test3() {
        int i = random.nextInt(100);
        Assertions.assertTrue(i >= 70);
        System.out.println("==== TEST 3 ====");
    }

    @Test
    public void appleModelNumberTest() {
        Assertions.assertTrue(apple.modelNumber >= 3);
    }

    public void smth(String s) {
        System.out.println(s.length());
    }

    public int randomInt() {
        return random.nextInt(100);
    }
}