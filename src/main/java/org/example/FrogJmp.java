package org.example;

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(99, 987654321, 1));
    }

    public static int solution(int X, int Y, int D){
        if(X==Y) {
            return 0;
        } else if (D>Y-X || (Y-X)/D==0){
            return 1;
        } else if (D==1) {
            return Y-X;
        } else {
            if((((Y-X)*10)/D)%10!=0){
                return jumpCount(X,Y,D)+1;
            }
            return jumpCount(X,Y,D);
        }
    }
    public static int jumpCount(int X, int Y, int D){
        return (Y-X)/D;
    }
}
