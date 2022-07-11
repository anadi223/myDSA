package com.demo.StriverSDESheet.Arrays.Day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question3 {
    public static void main(String[] args) {
        
    }

    //https://www.codingninjas.com/codestudio/problems/759408?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

    //https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1/#
    //! TC O(NLOGN) SC O(1)
    static int longestConsecutiveSequenceAppraoch1(int[] arr, int n){
        Arrays.sort(arr);
        int ans = 1;
        int prev = arr[0];
        int curr = 1;

        for(int i=1;i<n;i++){
            if(arr[i] == prev+1){
                curr++;
            }
            else if(arr[i] != prev){
                curr = 1;
            }
            prev = arr[i];
            ans =Math.max(ans, curr);
        }
        return ans;
    }
    // TC O(n) SC O(N)
    // /We will first push all are elements in the HashSet. Then we will run a for loop and check for any number(x) if it is the starting number of the consecutive sequence by checking if the HashSet contains (x-1) or not. If ‘x’ is the starting number of the consecutive sequence we will keep searching for the numbers y = x+1, x+2, x+3, ….. And stop at the first ‘y’ which is not present in the HashSet. Using this we can calculate the length of the longest consecutive subsequence. 
    public static int longestConsecutive(int[] nums) {
        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num: nums) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
