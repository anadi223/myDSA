package com.demo.LightLightWeight.DynamicProgrammingAdityaVerma;

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
}