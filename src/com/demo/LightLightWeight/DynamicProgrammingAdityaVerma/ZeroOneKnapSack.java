package com.demo.LightLightWeight.DynamicProgrammingAdityaVerma;

import java.util.Arrays;

class ZeroOneKnapSack{
    public static void main(String[] args) {
        
    }
    //https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/#  //& TLE MAAR GYA KUCH TEST CASES KE LIYE AAGE OPTIMIZE KARENGE
    //* 0-1 KnapSack Recursive Solution */
    //* NOTES DEKHO BAHOT ACHA SMJHAYA HAI */
    static int profitMaxRecursive(int[] wt, int[] val , int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            return Math.max(val[n-1] + profitMaxRecursive(wt, val, W-wt[n-1], n-1), profitMaxRecursive(wt, val, W, n-1));
        }else if(wt[n-1] > W){
            return profitMaxRecursive(wt, val, W, n-1);
        }
        return -1;
    }

    
    static int profitMaxMemoizedInitialization(int[] wt, int[] val , int W, int n){
        int[][] t =new int[n+1][W+1]; // matrix to store the answers,,
        
        // fill the table initially with -1
        for (int[] v : t) {
          Arrays.fill(v, -1);
        }
        int ans=profitMaxMemoized(wt, val, W, n, t);
        return ans;
    }

    static int profitMaxMemoized(int[] wt, int[] val , int W, int n, int[][] t){
        if(n == 0 || W == 0){
            return 0;
        }

        if(t[n][W] != -1){
            return t[n][W];
        }

        if(wt[n-1] <= W){
            t[n][W] =Math.max(val[n-1] + profitMaxMemoized(wt, val, W-wt[n-1], n-1,t), profitMaxMemoized(wt, val, W, n-1,t)); //store krwa lo phle matrix me phr return karo 
            return t[n][W];
           
        }else if(wt[n-1] > W){
            t[n][W] =profitMaxMemoized(wt, val, W, n-1,t); //store then return
            return t[n][W];
            
        }
        return -1;
    }
}