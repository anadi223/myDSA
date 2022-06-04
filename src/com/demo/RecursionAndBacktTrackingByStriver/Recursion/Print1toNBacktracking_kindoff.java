package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

public class Print1toNBacktracking_kindoff {
    public static void main(String[] args) {
        print(3,3);
    }
    static void print(int i,int n){
        if(i<1){
            return;
        }
        print(i-1,n);
        System.out.println(i);
    }
}
