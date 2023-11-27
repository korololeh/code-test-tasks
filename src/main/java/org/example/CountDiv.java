package org.example;

public class CountDiv {
    public static void main(String[] args) {
//        System.out.println(solution(6,11,2));
        System.out.println(solution(6, 11, 2));
        System.out.println(solution(11, 345, 17));
        System.out.println(solution(11, 345, 17));
    }
    public static int solution(int A, int B, int K){
        return B/K - (A%K==0 ? A/K-1 : A/K);
    }
}
