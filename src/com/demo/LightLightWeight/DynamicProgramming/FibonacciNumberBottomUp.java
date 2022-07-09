package com.demo.LightLightWeight.DynamicProgramming;

import java.util.Arrays;

//TC O(n) SC O(n) //better space than top down
public class FibonacciNumberBottomUp {
    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
    }


    static int findFib(int n, int[] dp){

        dp[0] = 0; // initally ye values toh rhengi hi
        dp[1] = 1;

        for(int i =2;i<=n;i++){ //loop chla diya 
            dp[i] = dp[i-1]+dp[i-2]; // jo recursive call tha usko hta diya 
        }
        return dp[n];
        }
}
