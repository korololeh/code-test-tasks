//package org.example;
//
//public class Test {
//
//    public static void main(String[] args) {
//        int n = 35;
//        for (int i = n; i < n + 30; i++) {
//            if (i % 7 == 0) {
//                continue;
//            } else if (String.valueOf(i).contains("7")) {
//                continue;
//            } else if (isDivisibleBySeventh(i)) {
//                continue;
//            }
//            return i;
//        }
//    }
//
//    public static boolean isDivisibleBySeventh(int num) {
//        for (int i = 17; i < num / 2; i += 1) {
//            if (String.valueOf(i).contains("7")) {
//                if (num % i == 0) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}
