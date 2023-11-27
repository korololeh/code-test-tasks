package org.example;

import java.util.Arrays;

public class PermCheck {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,4,4,5}));
    }

    public static int solution(int[] A) {
        if (A[0]!=1 && A.length < 2) {
            return 0;
        } else if (Arrays.stream(A).max().getAsInt() > A.length) {
            return 0;
        }
        int expectedSum = expectedArrSum(A.length);
        if (expectedSum == Arrays.stream(A).distinct().sum()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int expectedArrSum(int n) {
        return (n * (n + 1)) / 2;
    }
}
