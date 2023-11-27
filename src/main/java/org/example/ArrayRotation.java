package org.example;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int i = 1;
        System.out.println(Arrays.toString(solution(new int[]{1,2}, i)));
    }

    public static int[] solution(int[] A, int K) {
        int[] arrAfterMoving = new int[A.length];
        if (A.length==0 || K==0) {
            return A;
        } else if (A.length == K && K % A.length == 0) {
            return A;
        } else {
            int j = 0;
            int lastElsToMove = A.length - K % A.length;
            for (int i = (K % A.length); i < arrAfterMoving.length; i++, j++) {
                arrAfterMoving[i] = A[j];
            }
            for (j = 0; j < K % A.length; j++, lastElsToMove++) {
                arrAfterMoving[j] = A[lastElsToMove];
            }
        }
        return arrAfterMoving;
    }
}
