package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

public class Print5NamesRecursion {
    public static void main(String[] args) {
        int n=0;
        print(n);
    }
    static void print(int n){
        if(n==5)
            return;
        System.out.println("Print");
        n++;
        print(n);
    }
}
