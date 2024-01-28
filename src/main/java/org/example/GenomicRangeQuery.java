package org.example;

import java.util.*;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
    }

    public static int[] solution(String dna, int[] starts, int[] ends) {
        int[] res = new int[starts.length];
        int[][] mapArr = new int[dna.length() + 1][4];
        mapArr[0] = new int[]{0, 0, 0, 0};

        for(int i =0; i<dna.length(); i++){
            char ch = dna.charAt(i);
            int chIndex = ch == 'A' ? 0 : ch == 'C' ? 1 : ch == 'G' ? 2 : 3;

            int[] map = mapArr[i];
            mapArr[i + 1] = map.clone();
            mapArr[i + 1][chIndex] += 1;
        }

        for (int i = 0; i < starts.length; i++) {
            int aCount = mapArr[ends[i] + 1][0] - mapArr[starts[i]][0];
            int cCount = mapArr[ends[i] + 1][1] - mapArr[starts[i]][1];
            int gCount = mapArr[ends[i] + 1][2] - mapArr[starts[i]][2];

            res[i] = aCount > 0 ? 1 : cCount > 0 ? 2 : gCount > 0 ? 3 : 4;
        }

        return res;
    }
}
