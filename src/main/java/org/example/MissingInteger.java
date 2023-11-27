package org.example;

import java.util.Arrays;

public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1,2, 3, 4, 6, -2, -3, -5, -8, 2, 8, 3, 4, 5, 7}));
    }

    public static int solution(int[] A) {
        int[] arr = Arrays.stream(A).distinct().filter(x -> x > 0).sorted().toArray();
        if (arr.length == 0) {
            return 1;
        } else if (arr[0] == 1) {
            int currentVal = 2;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != currentVal) {
                    return currentVal;
                }
                currentVal++;
            }
            return currentVal;
        } else {
            return 1;
        }
    }
}
