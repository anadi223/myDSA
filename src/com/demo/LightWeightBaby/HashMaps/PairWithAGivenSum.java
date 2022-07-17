package com.demo.LightWeightBaby.HashMaps;

import java.util.HashSet;
// Pair Sum Question
public class PairWithAGivenSum {
    public static void main(String[] args) {
        int[] arr = {3,2,8,15,-8};
        int target = 17;
        boolean ans = findSumPresent(arr, target);
        System.out.println(ans);
    }

    static boolean findSumPresent(int[] arr,int target){
        HashSet<Integer> hs = new HashSet<>();
        boolean ans = false;
        for(int i=0;i<arr.length;i++){
            if(hs.contains(target-arr[i])){
                ans = true;
            }else{
                hs.add(arr[i]);
            }
        }
        return ans;
    }
}
