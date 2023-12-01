package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IncreaseDigitInString {
    public static void main(String[] args) {
//          String input = "DRMV45QWE875675IS1234567";
//          String input = "DRMV45QWE875675IS1234569";
//          String input = "DRMV45QWE875675IS0001234569";
//        String input = "DRMV45QWE875675IS000000";
        String input = "DRMV45QWE875675IS999999";
        System.out.println(increasedNumber(input));
    }

    public static String increasedNumber(String input){
        String digits;
        String matcher = "(\\d*)$";
        Pattern pattern = Pattern.compile(matcher);
        Matcher match = pattern.matcher(input);
        if(match.find()){
            digits = match.group();
        } else {
            return input;
        }
        if(digits.equals("9".repeat(digits.length()))){
            return input.replace(digits,digits.replaceAll("9","0"));
        }

        int number = Integer.parseInt(digits);
        return input.replace(String.valueOf(number), String.valueOf(number+1));
    }
}
