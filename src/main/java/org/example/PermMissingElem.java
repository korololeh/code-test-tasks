package org.example;

import java.util.Arrays;

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 8, 3, 4, 5, 7}));
    }

    public static int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        return expectedArrSum(A.length + 1) - Arrays.stream(A).sum();
    }

    public static int expectedArrSum(int n) {
        return (n * (n + 1)) / 2;
    }
}