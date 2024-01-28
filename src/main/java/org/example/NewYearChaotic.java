//package org.example;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class NewYearChaotic {
//    public static void main(String[] args) {
//        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 5, 3 ,7 ,8, 6, 4));
//        int result = countBribes(arr);
//        if (result > 0) {
//            System.out.println(result);
//        } else {
//            System.out.println("Too chaotic");
//        }
//    }
//
//    public static int expectedArrSum(int n) {
//        return (n * (n + 1)) / 2;
//    }
//
//    public static int countBribes(List<Integer> arr) {
//        if (expectedArrSum(arr.size() + 1) - arr.stream().reduce(0, Integer::sum) < 0) {
//            return -1;
//        }
//        int sumResult = 0;
//        int numberOfBribes = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            int resultPos = arr.get(i)-1 - i;
//            if (resultPos > 2) {
//                return -1;
//            } else {
//                sumResult += resultPos;
//                if (resultPos > 0) {
//                    numberOfBribes += resultPos;
//                }
//            }
//        }
//        return numberOfBribes;
//    }
//}

//TODO https://www.hackerrank.com/challenges/new-year-chaos/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays


//1 2 5 3 7 8 6 4

//How it works by code:
/*
it1 = 1 2 5 3 7 8 6 4 move "5" index 2 to index 4 - 2 bribes
it2 = 1 2 5 3 7 8 6 4 move "7" index 4 to index 6 - 2 bribes
it3 = 1 2 5 3 7 8 6 4 move "8" index 5 to index 7 - 2 bribes
result:
it3 = 1 2 5 3 7 6 4 8
it2 = 1 2 5 3 6 4 7 8
it1 = 1 2 3 6 5 4 7 8
*/

//Line moving
//it1 5 +2 position ==> 12375864
//it2 12375864 ==> 7 +2 position ==> 12358764 - fail


