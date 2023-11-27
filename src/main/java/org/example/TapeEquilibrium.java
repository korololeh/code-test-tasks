package org.example;

import java.util.Arrays;

public class TapeEquilibrium {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{3, 1, 2,4,3}));
        System.out.println(solution(new int[]{-1000, 1000}));
//        System.out.println(solution(new int[]{3, 1, 1}));
    }

    public static int solution(int[] A) {
        int arrLength = A.length;
        if (arrLength<2){
            return 0;
        }
        int arrSum = Arrays.stream(A).sum();
        return findMinDifference(arrLength, A, arrSum);
    }

    public static int findMinDifference(int arrLength, int[] A, int arrSum) {
        int minDiff = Integer.MAX_VALUE;
        int currentSum=0;
        for (int i = 0; i < arrLength-1; i++) {
            currentSum+=A[i];
            int currentDiff = Math.abs((arrSum -currentSum)-currentSum);
            minDiff=Math.min(minDiff, currentDiff);
        }
        return minDiff;
    }
}
