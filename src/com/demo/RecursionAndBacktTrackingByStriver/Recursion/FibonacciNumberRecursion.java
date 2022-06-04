package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

public class FibonacciNumberRecursion {
    public static void main(String[] args) {

        int a = fibonacci(4);
        System.out.println(a);

    }
    static int fibonacci(int n){
        if(n<=1)
            return n;

        return fibonacci(n-1)+fibonacci(n-2);
    }
}
