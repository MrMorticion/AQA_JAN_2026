package org.prog.session4;

//TODO: print only correct emails
// Correct email rules:
// - at least 3 symbols before @
// - only @ symbol
// - full domain name (must have at least one ".")


public class Hwversion2 {

    public static void main(String[] args) {
        String[] emails = new String[]{
                "abcdefg@gmail.com", //+
                "a@gmail.com", //-
                "josh@@gmail.com", //-
                "janegmail.com", // -
                "pete@gmail.com", //+
                "zoe@gmailcom", //-
                "steve@outlook.com", //+
                "abcd@a.a", //+
                "abcd.a@fakemail" //-
        };

        for (int i = 0; i < emails.length; i++) {
            String top = emails[i];

            int моятебянепонимать = top.indexOf('@');
            if (моятебянепонимать== -1) {
                System.out.println("fail: no @ - " + top);
            } else if (моятебянепонимать != top.lastIndexOf('@')) {
                System.out.println("fail: multiple @ - " + top);
            } else if (моятебянепонимать < 3) {
                System.out.println("fail: too few characters before @ - " + top);
            } else {
                String domain = top.substring(моятебянепонимать + 1);
                if (!domain.contains(".")) {
                    System.out.println("fail: domain missing '.' - " + top);
                } else {
                    System.out.println("right - " + top);
                }
            }
        }


        {

            }
        }
    }







