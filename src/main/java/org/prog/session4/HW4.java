package org.prog.session4;
//TODO: print only correct emails
// Correct email rules:
// - at least 3 symbols before @
// - only @ symbol
// - full domain name (must have at least one ".")


import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class HW4 {
    public static void main(String[] args) {
        String[] emails = new String[]
                {
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
        boolean found = false;
        for (int p = 0; p < emails.length; p++) {


            String current = emails[p];
            char[] chars = current.toCharArray();
            int countAt = 0;
            int countDotAfterAt = 0;
            int lenghtBeforeAt =0;
            int symbolsAfrerAt =0;
            int symbolsAfterDot =0;
            boolean foundAt = false;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '@') {
                    countAt++;
                    foundAt = true;
                } else  if (!foundAt) {
                    lenghtBeforeAt++;  symbolsAfrerAt++;
                } else if ( foundAt && c == '.') {
                    countDotAfterAt++ ;  symbolsAfterDot++;
                }
                if ( lenghtBeforeAt >= 3  && countAt == 1 && symbolsAfrerAt <= 10 && countDotAfterAt == 1 && symbolsAfterDot <=3) {
                    System.out.println(current + " Right ");
                } else {
                    System.out.println(current + " fail ");


                }
                }

                }



        }

    }




