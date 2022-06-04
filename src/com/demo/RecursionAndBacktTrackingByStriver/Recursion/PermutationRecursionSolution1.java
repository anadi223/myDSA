package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

import java.util.ArrayList;
import java.util.List;


//Solution 1 with more space complexity
public class PermutationRecursionSolution1 {
    public static void main(String[] args) {
        int[] candidates = {1,2,3};
        System.out.println(permutation(candidates));
    }

    static void findPermutation(int[] arr, List<List<Integer>> ans , List<Integer> a , boolean[] map){

        if(a.size() == arr.length){ //base case
            ans.add(new ArrayList<>(a));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!map[i]){ //initially map will be false so we need to check if and only if it is false then only you go inside the loop
                map[i] = true;
                a.add(arr[i]);
                findPermutation(arr,ans,a,map);
                map[i] = false;
                a.remove(a.size()-1);
            }
        }
    }

    static List<List<Integer>> permutation(int[] candidates){

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] map = new boolean[candidates.length];

        findPermutation(candidates,ans,new ArrayList<>(),map);

        return ans;
    }
}
