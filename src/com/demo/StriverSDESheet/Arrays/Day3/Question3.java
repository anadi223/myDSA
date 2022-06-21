package com.demo.StriverSDESheet.Arrays.Day3;


import java.util.HashMap;

//https://leetcode.com/problems/majority-element/
public class Question3 {
    public static void main(String[] args) {
        int[] arr ={5,2,0,0};
        // int ans = findMajorityElementApproach1(arr, arr.length);
        int ans = findMajorityElementApproach2(arr, arr.length);
        System.out.println(ans);
    }
    //
    static int findMajorityElementApproach1(int[] arr, int n){
        HashMap<Integer,Integer> map = new HashMap<>();

        int count =1;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                count+=map.get(arr[i])+1;
                if(count > n/2){
                    return arr[i];
                }else{
                    map.put(arr[i], count);
                }
            }else{
                map.put(arr[i], 1);
            }
        }
        return -1;
}
    //MOORE VOTING ALGORITHM TC O(n) SC O(1) APPRAOCH DISCUSSED IN NOTES
    static int findMajorityElementApproach2(int[] arr, int n){
        int count=0;
        int element =0;

        for(int i=0;i<n;i++){
            if(count ==0){
                element = arr[i];
            }
            if(arr[i] == element){
                count++;
            }else{
                count--;
            }
        }
        return element;
    }



}
