package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

import java.util.ArrayList;
import java.util.List;

//Notes Print Sum Subsequence whose sum is K
public class PrintSubsequencewhoseSumIsK {
    public static void main(String[] args) {
       int[] arr = {1,2,1};
        ArrayList<Integer> a = new ArrayList<>();
        int sumGiven=2;
        printSub(0,a,arr,0,sumGiven);

    }
    static void printSub(int i, List<Integer> a , int[] arr , int variableSum, int sumGiven){
        if(i == arr.length){
            if(variableSum == sumGiven){
                System.out.println(a);
            }
            return;
        }
        a.add(arr[i]);
        variableSum+=arr[i];
        printSub(i+1,a,arr,variableSum,sumGiven);//take
        a.remove(a.size()-1);
        variableSum-=arr[i];
        printSub(i+1,a,arr,variableSum,sumGiven);//not take

    }




}
