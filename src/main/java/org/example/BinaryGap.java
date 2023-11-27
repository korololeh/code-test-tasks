package org.example;

public class BinaryGap {
    public static void main(String[] args) {
        longestBinaryGap(32);
    }

    public static int longestBinaryGap(int num){
        String bin = Integer.toBinaryString(num);
        if(!bin.contains("0")){
            return 0;
        } else if(bin.lastIndexOf("1") == bin.length()-1){
            return getMaxZeroSequenceFromBin(bin);
        } else {
            String binsBetweenOnes = bin.substring(0, bin.lastIndexOf("1"));
            return getMaxZeroSequenceFromBin(binsBetweenOnes);
        }
    }
    public static int getMaxZeroSequenceFromBin(String bin){
        int maxBinLength=0;
        String[] zero = bin.split("1");
        for(String el : zero){if (el.length()>maxBinLength){maxBinLength=el.length();}}
        return maxBinLength;
    }
}
