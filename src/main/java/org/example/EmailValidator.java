package org.example;

public class EmailValidator {
    public static void main(String[] args) {
        System.out.println(emailValidation("@gmail.com"));
        System.out.println(emailValidation("a@gmail.com"));
        System.out.println(emailValidation(".@gmail.com"));
        System.out.println(emailValidation("agmail.com"));
        System.out.println(emailValidation("97s@gmail.com"));
        System.out.println(emailValidation("a@gm@ail.com"));
        System.out.println(emailValidation("aqwer@gm.qwerail.com"));
        System.out.println(emailValidation("@gmail.com"));
    }

    public static boolean emailValidation(String email) {
        int atIndex = email.indexOf("@");
        int dotLastIndex = email.lastIndexOf(".");

        if (email.isEmpty()) {
            return false;
        } else if (email.contains(" ")) {
            return false;
        } else if (email.chars().filter(x -> x == '@').count() > 1) {
            return false;
        } else if (!email.contains(".") || !email.contains("@")) {
            return false;
        } else if (dotLastIndex < atIndex) {
            return false;
        } else if (email.indexOf(".") < 1 || atIndex < 1) {
            return false;
        } else if (email.substring(atIndex+1, dotLastIndex-1).chars().distinct().filter(x->!Character.isAlphabetic(x)).count() > 0) {
            return false;
        } else if (email.substring(dotLastIndex+1).chars().distinct().filter(x->!Character.isAlphabetic(x)).count() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
