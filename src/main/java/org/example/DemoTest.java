package org.example;

import java.util.Arrays;

public class DemoTest {
        public static int solution(int[] A) {
            // Implement your solution here
            int [] arr = Arrays.stream(A).boxed().distinct().sorted().filter(x->x>0).mapToInt(Integer::intValue).toArray();
            int lost=arr[0];
            for(int i=1; i<arr.length; i++){
                if(arr[i]!=lost+1){return lost+1;}
                else {lost=arr[i];}
            }
            return lost;
        }

    public static void main(String[] args) {
        int[] arr = {-1,10,1,21,3,0,5,6,2,7};
        System.out.println(solution(arr));
    }
}
