package org.example;

import java.util.regex.Pattern;

public class TestTask {
    public static void main(String[] args) {
//        System.out.println(emailValidation("@gmail.com"));
//        System.out.println(emailValidation("a@gmail.com"));
//        System.out.println(emailValidation(".@gmail.com"));
//        System.out.println(emailValidation("agmail.com"));
//        System.out.println(emailValidation("a@gmailcom"));
        String matcher = "[A-Za-z0-9](.*)";
        System.out.println(Pattern.compile(matcher).matcher("@gmail.com").matches());
    }

    public static boolean emailValidation(String email) {
        if (!email.contains(".") || !email.contains("@")) {
            return false;
        } else if (email.lastIndexOf(".") < email.lastIndexOf("@")) {
            return false;
        } else if (email.indexOf(".") < 1 || email.indexOf("@") < 1) {
            return false;
        } else {
            return true;
        }
    }
}
