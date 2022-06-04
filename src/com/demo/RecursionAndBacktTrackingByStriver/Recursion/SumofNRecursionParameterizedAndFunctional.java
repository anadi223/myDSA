package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

public class SumofNRecursionParameterizedAndFunctional {
    public static void main(String[] args) {

        parameterized(3,0);
        System.out.println("Functional result  "+functional(3));

    }
    static void parameterized(int i,int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        parameterized(i-1,sum+i);
    }

    static int functional(int n){
        if(n==0){
            return 0;
        }
        return n+functional(n-1);
    }
}
