package org.example;

import java.util.Arrays;

public class PassingCars {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1}));
    }

    public static int solution(int[] A) {
        if (Arrays.stream(A).filter(x -> x != 0 && x != 1).findAny().isPresent()) {
            return -1;
        }
        int westSum = Arrays.stream(A).filter(x -> x == 1).sum();
        int paired = 0;
        int pairs = 0;
        if ((westSum < A.length) && (westSum >= 1)) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] == 0) {
                    pairs += westSum - paired;
                }
                paired += A[i];
            }
        }
        if (pairs < 0 || pairs > 1000000000) {
            return -1;
        } else {
            return pairs;
        }
    }
}
