package org.example;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Strings {
    public static void main(String[] args) {
        String input = "GeekForGeek";
        System.out.println(func(input));
    }

    public static String func(String input){
        return Arrays.stream(input.toLowerCase().split(""))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1)
                .map(Map.Entry::getKey).collect(Collectors.joining());
    }
}