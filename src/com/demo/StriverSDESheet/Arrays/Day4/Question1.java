package com.demo.StriverSDESheet.Arrays.Day4;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
//https://www.codingninjas.com/codestudio/problems/pair-sum_697295?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
public class Question1 {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target =9;
       // int[] ans  = pairSumApproach1(arr, target);
       int[] ans = pairSumApproach2(arr, target);
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
    //TC O(n2) SC O(1)
    static int[] pairSumApproach1(int[] arr, int target){
        int[] ans = new int[2];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }


    // TC O(nlogn) SC O(n)
    static int[] pairSumApproach2(int[] arr, int target){

        int[] sortedCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedCopy); // hmne array ko sort kar diya 
        int[] ans = new int[2]; // answer array
        int n = sortedCopy.length;
        //following two pointer appraoch
        int left=0,right= n-1;
        int n1=0, n2=0; // n1 n2 sorted array me index  nikalenge jo baad me original array me index btayenge

        while(left<right){
            if(sortedCopy[left] + sortedCopy[right] == target){
                n1 = sortedCopy[left];
                n2 = sortedCopy[right];
                break; // jaise hi ye condition ho jaaye loop se bahar aa jao
            }
            else if(sortedCopy[left] + sortedCopy[right] > target){
                right--; // are bhai sorted array me right most is the biggest element aur hmko target ke paas aana hai toh right ko chota hona pdega
            }else{
                left++;
            }
        }

        for(int i=0;i<arr.length;i++){ // hmne n1 n2 nikala hai lekin wo element sorted array ka hai toh wo index answer nhi hoga 
            if(arr[i] == n1){ //hm un element ko khoj rhe apne original array me aur original array ka index nikal ke answer me daal de rhe
                ans[0] = i;
            }else if(arr[i] == n2){
                ans[1] = i;
            }
        }
        return ans;
    }
    //TC O(n) SC O(n)
    static int[] pairSumApproach3(int[] arr, int target){
        int[] ans = new int[2];
        HashMap<Integer,Integer> track  = new HashMap<>(); 
        for(int i = 0;i<arr.length;i++){
            if(track.containsKey(target - arr[i])){ // agar target - i ka value hai 
                ans[1] = i; 
                ans[0] = track.get(target - arr[i]); //map me se index nikal rhe hai 
            }
            else{
            track.put(arr[i], i); // value ke against index store krwa rhe
        }
    }
        return ans;
    }
}
