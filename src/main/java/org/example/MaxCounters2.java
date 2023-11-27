package org.example;

import java.util.Arrays;

public class MaxCounters2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(7, new int[]{3, 6, 3, 6, 2, 7})));
    }

    public static int[] solution(int N, int[] A) {
        int[] arrCounters = new int[N];
        int maxVal = 0;
        int resetVal=0;
        for(int i=0; i< A.length; i++){
            int val = A[i];
            int arrIndex=val-1;
            if(val<=N){
                int currentVal = arrCounters[arrIndex];
                if(currentVal<resetVal){
                    currentVal=resetVal;
                }
                currentVal++;
                maxVal = Math.max(maxVal, currentVal);
                arrCounters[arrIndex] = currentVal;
            } else {
                resetVal= maxVal;
            }
        }

        for (int i=0; i<arrCounters.length; i++){
            if (arrCounters[i]<resetVal){
                arrCounters[i]=resetVal;
            }
        }
        return arrCounters;
    }
}
