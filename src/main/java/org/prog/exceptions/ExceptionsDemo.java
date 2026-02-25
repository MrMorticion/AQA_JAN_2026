package org.prog.exceptions;

public class ExceptionsDemo {

    public static void main(String[] args) {
        ExceptionsDemo demo = new ExceptionsDemo();
        demo.method1("test");
        demo.method1(null);
        System.out.println("==============================");
    }

    public void method1(String str) {
        method2(str);
    }

    public void method2(String str) {
        method3(str);
    }

    public void method3(String str) {
        method4(str);
    }

    public void method4(String str) {
        method5(str);
    }

    public void method5(String str) {
        try {
            System.out.println(str.length());
        } catch (Exception e) {
            System.out.println("OOPS!");
        } finally {

        }
    }
}
