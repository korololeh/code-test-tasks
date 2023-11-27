package org.example;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class EmailValidator {
    public static void main(String[] args) {
//        System.out.println(emailValidation("@gmail.com"));
//        System.out.println(emailValidation("a@gmail.com"));
//        System.out.println(emailValidation(".@gmail.com"));
//        System.out.println(emailValidation("agmail.com"));
        System.out.println(emailValidation("a@gmail.com"));
//        String matcher = "[A-Za-z0-9](.*)";
//        System.out.println(Pattern.compile(matcher).matcher("@gmail.com").matches());
    }

    public static boolean emailValidation(String email) {
        int atIndex = email.indexOf("@");
        int dotLastIndex = email.lastIndexOf(".");

        if (email.chars().filter(x -> x == ' ').count() > 1) {
            return false;
        } else if (email.chars().filter(x -> x == '@').count() > 1) {
            return false;
        } else if (!email.contains(".") || !email.contains("@")) {
            return false;
        } else if (dotLastIndex < atIndex) {
            return false;
        } else if (email.indexOf(".") < 1 || atIndex < 1) {
            return false;
        } else if (email.chars().skip(atIndex).limit(dotLastIndex).distinct().filter(x->!Character.isAlphabetic(x)).count() > 0) {
            return false;
        } else if (email.chars().skip(dotLastIndex).distinct().filter(x->!Character.isAlphabetic(x)).count() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
