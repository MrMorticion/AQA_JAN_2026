package org.prog.session13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

//TODO: Using class Androind OR Apple:
//TODO: Add field int modelNumber
//TODO: Assign model as random 1-5
//TODO: Write test that confirms model number is 3 or above

public class JUnitTests {

    private Random random = new Random();

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

    public void smth(String s) {
        System.out.println(s.length());
    }

    public int randomInt() {
        return random.nextInt(100);
    }
}
