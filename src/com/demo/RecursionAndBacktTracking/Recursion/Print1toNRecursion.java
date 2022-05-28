package com.demo.RecursionAndBacktTracking.Recursion;

import java.util.Scanner;

public class Print1toNRecursion {
    public static void main(String[] args) {
        int i=1;
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter n");
        int n =s1.nextInt();
        print(i,n);
    }
    static void print(int i,int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        print(i+1,n);
    }
}


