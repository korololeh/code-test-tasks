package org.example;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


public class OddOccurrencesInArray {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1,2,5,3,3,2,1}));
        System.out.println(solutionAlt(new int[]{1,2,5,3,3,2,1}));
    }

    public static int solution(int[] A){
        if(A.length%2==0) {return 0;}
        Map<Integer, Long> grouping = Arrays.stream(A).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        return grouping.entrySet().stream().filter(x -> x.getValue() % 2 != 0).findFirst().get().getKey();
    }
    public static int solutionAlt(int[] A){
        if(A.length%2==0) {return 0;}
        int[] B = Arrays.stream(A).sorted().toArray();
        int currentNum=B[0];
        for(int i=0;i<B.length;i++){
            if(B[i]!=currentNum && (i+1)%2==0){
                return currentNum;
            } else {
                currentNum = B[i];
            }
        }
        return currentNum;
    }

}
