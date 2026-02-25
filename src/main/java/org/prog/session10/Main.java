package org.prog.session10;

public class Main {

    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = "s1";

        boolean b = s1.equals(s2);

        String result = b ? "yes" : no();

        if (b) {
            result = "yes";
        } else {
            result = "no";
        }

        System.out.println(result);
    }

    public static String no(){
        return "no";
    }
}
