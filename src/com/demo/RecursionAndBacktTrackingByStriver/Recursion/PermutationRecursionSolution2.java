package com.demo.RecursionAndBacktTrackingByStriver.Recursion;


import java.util.*;
public class PermutationRecursionSolution2 {
    public static void main(String[] args) {
        int[] candidates = {1,2,3};
        System.out.println(permutation(candidates));
    }

    static void findPermutation(int index,int[] arr, List<List<Integer>> ans){

        if(index == arr.length){
            List<Integer> a = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                a.add(arr[i]);
            }
            ans.add(new ArrayList<>(a));
            return;
        }

        for(int i=index;i<arr.length;i++){
            swap(i,index,arr);
            findPermutation(index+1,arr,ans);
            swap(i,index,arr);
        }

    }

    static void swap(int i,int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static List<List<Integer>> permutation(int[] candidates){
        List<List<Integer>> ans  = new ArrayList<>();
        findPermutation(0,candidates,ans);
        return ans;
    }
}
