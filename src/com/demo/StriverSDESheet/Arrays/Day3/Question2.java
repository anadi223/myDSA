package com.demo.StriverSDESheet.Arrays.Day3;

//https://leetcode.com/problems/powx-n/
//POW(x,n)
public class Question2 {
    public static void main(String[] args) {
        double x=2.10000;
        int n = 3;
        // double ans = powerOfApproach1(x, n);
        double ans = powerOfApproach2(x, n);
        System.out.println(ans);
    }
        //TC O(n) SC O(1)
    static double powerOfApproach1(double x, int n){
        double ans = 1;

        for(int i=1;i<=n;i++){
            ans =ans*x;
        }
        return ans;
    }
    //TIME COMPLEXITY O(log n) SC O(1)
    static double powerOfApproach2(double x, int n){
        double ans = 1.0;
        long nn = n; //to check if n is negative

        if(nn<0) nn=(-1)*nn;

        while(nn>0){
            if(nn%2==1){ // reason in notes
                ans = ans*x;
                nn = nn-1;
            }else{
                x = x*x;
                nn=nn/2;
            }
        }

        if(n<0){
            ans = (double) 1.0 / (double) ans;
        }
        return ans;
    }
}
