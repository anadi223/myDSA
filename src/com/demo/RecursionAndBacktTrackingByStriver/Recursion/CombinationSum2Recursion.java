package com.demo.RecursionAndBacktTracking.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Notes Combination Sum 2
public class CombinationSum2Recursion {
    public static void main(String[] args) {

        int[] candidate= {1,1,1,2,2};
        int target =4;
        System.out.println(combinationSum(candidate,target));

    }
    static void findCombination(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> a){
        if(target==0){
            ans.add(new ArrayList<>(a));
            return;
        }

        for(int i=ind; i<arr.length;i++) {
            if (i > ind && arr[i] == arr[i - 1])continue; //to avoid repetations to be checked as the current index
            if(arr[i]>target) break; // agar element hi bda hai toh minus kya kroge


            a.add(arr[i]);
            findCombination(i+1,arr,target-arr[i],ans,a); //i+1 kyuki for loop last me increment krega i ko aur hmko recursion call krna hai next index ke lie
            a.remove(a.size()-1);
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

}
