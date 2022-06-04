package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

public class PrintNto1Backtracking_kinfodd {
    public static void main(String[] args) {
        print(1,3);

    }
    static void print(int i,int n){
        //base condition
        if(i>n){
            return;
        }
        print(i+1,n);
        System.out.println(i);
    }
}
