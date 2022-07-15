package com.demo.StriverSDESheet.Arrays.Day4;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
public class Question4 {
    public static void main(String[] args) {
        int arr[] = {9,-3,3,-1,6,-5};
       //int ans = largestSubArrayApproach1(arr);
       int ans = largestSubArrayApproach2(arr);
        System.out.println(ans);
    }

    // TC O(n2) SC O(1)
    static int largestSubArrayApproach1(int[] arr){
        int max =0; // max count rakh lo jo har subarray me se jis subarray ka sum 0 hoga uska count rkhega
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum ==0){
                    max = Math.max(max, j-i+1); //(j-i+1 --> index) //hme longest length dena hai subarray ka is liye mmax function
                }
            }
        }
        return max;
    }

    //TC O(nlogn) SC O(n) Good concept
    static int largestSubArrayApproach2(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum == 0){ //if sum =0 toh dost max update kar do
                max = i+1;
            }
            else{
                if(map.get(sum) !=null){ // hashmap check karo agar wo sum present hai hashmap me toh dost max update kar do
                    max = Math.max(max, i- map.get(sum)); // (i-map.get(sum) == current index- value of index of sum present in map) //& SEE NOTES
                }else{
                    map.put(sum, i);
                }
            }
        }
        return max;
    }
}
