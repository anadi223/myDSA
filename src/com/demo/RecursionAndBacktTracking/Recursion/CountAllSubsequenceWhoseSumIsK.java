package com.demo.RecursionAndBacktTracking.Recursion;

import java.util.ArrayList;
import java.util.List;


//Notes Print subsequeunce  whose sum is k
public class CountAllSubsequenceWhoseSumIsK {
    public static void main(String[] args) {
       int[] arr = {1,2,1};
        int sumGiven=2;
        int count = countSub(0,arr,0,sumGiven);
        System.out.println(count+ " Count of subsequence");
    }
    static int countSub(int i, int[] arr , int variableSum, int sumGiven){
        if(i == arr.length){
            if(variableSum == sumGiven){
                return 1;
            }
            return 0;
        }
        variableSum+=arr[i];
        int l = countSub(i+1,arr,variableSum,sumGiven);//take
        variableSum-=arr[i];
        int r= countSub(i+1,arr,variableSum,sumGiven);//not take

        return l+r;
    }





}
