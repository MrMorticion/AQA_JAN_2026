package org.prog.session10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

// TODO: Create MyPhoneException (parent - RuntimeException)
// TODO: In each phone (Apple and Androind) in hash code and equals:
// TODO: - if model or color are null -> throw MyPhoneException
// TODO: - Intercept that exception and print "oops!"

public class ExceptionsDemo {

    public static void main(String[] args) {
        ExceptionsDemo demo = new ExceptionsDemo();
        demo.method1("test");
        demo.method1(null);
        System.out.println("==============================");
    }

    public static void readFile1() {
        readFile2();
    }

    public static void readFile2() {
        readFile3();
    }

    public static void readFile3() {
        try {
            FileReader fr = new FileReader(new File("asd.txt"));
        } catch (FileNotFoundException e) {
            throw new MyException("File not found!");
        } finally {
            //close connections
        }
    }

    public void method1(String str) {
        method2(str);
    }

    public void method2(String str) {
        try {
            //NPE
            method3(str);
        } catch (ArithmeticException arithmeticException) {
            System.out.println("ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (NullPointerException nullPointerException) {
            System.out.println(">>>> NullPointerException");
        } catch (RuntimeException runtimeException) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public void method3(String str) {
        method4(str);
    }

    public void method4(String str) {
        method5(str);
    }

    public void method5(String str) {
        System.out.println(str.length());
    }
}
