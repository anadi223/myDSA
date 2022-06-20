package com.demo.StriverSDESheet.Arrays.Day2;

import java.util.Arrays;
import java.util.HashSet;

//https://www.codingninjas.com/codestudio/problems/1112602?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
public class Question4 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
       // int ans = findDuplicateApproach1(arr, arr.length);
       //int ans = findDuplicateApproach2(arr);
       int ans  =findDuplicateApproach3(arr);
        System.out.println(ans);
    }
    //khud se socha TC O(n) SC O(N)
    static int findDuplicateApproach1(int[] arr, int n){
        HashSet<Integer> set = new HashSet<>();
        int ans = -1;
        for(int i=0;i<arr.length;i++){
            if(!set.add(arr[i])){
                ans = arr[i];
                return ans;
            }
        }
        return -1;
    }
    //TC O(nlogn) SC O(1)
    static int findDuplicateApproach2(int[] arr){
        int ans = -1;
        Arrays.sort(arr);

        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                ans = arr[i];
            }
        }
        return ans;
    }

    static int findDuplicateApproach3(int[] arr){
        int slow = arr[0];
        int fast  = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow != fast);
        fast = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
