package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

import java.util.ArrayList;
import java.util.List;

// TIME COMPLEXITY  2^t * k
// When repetition is allowed in numbers
//Notes Combination Sum 1
public class CombinationSum1Recursion {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
  // since we wanted a list of combination of all target so thats why we need list of list of integers "ANS"
    static void findCombination(int i, int[] arr , int target, List<List<Integer>> ans, List<Integer> a){
        if(i == arr.length){  //base case
            if(target==0){
                ans.add(new ArrayList<>(a)); //Initializing the inner list as outer list is already initialized in the combinationSum function call;
            }
            return;
        }
        if(arr[i]<=target){ // when indexes are taken repedaetely
            a.add(arr[i]);
            findCombination(i,arr,target-arr[i],ans,a); // pick case
            a.remove(a.size()-1);
        }
        findCombination(i+1,arr,target,ans,a); // not pick case
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }



}
