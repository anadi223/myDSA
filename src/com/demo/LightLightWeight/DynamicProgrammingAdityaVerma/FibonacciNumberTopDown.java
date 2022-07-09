package com.demo.LightLightWeight.DynamicProgrammingAdityaVerma;

import java.util.Arrays;
//https://www.codingninjas.com/codestudio/problems/nth-fibonacci-number_74156?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

//TC O(n)  SC O(n) 
public class FibonacciNumberTopDown {
    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
    }


    static int findFib(int n, int[] dp){

        if(n <=1){ //base case
            return n;
        }

        if(dp[n] != -1){
            return dp[n]; // check kar rhe answer kahin phle se toh nhi nikal ke baitha hai if yes toh baaki ki calls nhi hongi seedha return ho jayega
        }

        dp[n]  = findFib(n-1, dp)+ findFib(n-2, dp); //save karwa rhe :: memoization
        return dp[n];

        }
}
