package com.demo.RecursionAndBacktTracking.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//bhai ne khud se kiyaaaaa

//Notes Subset Sum 1 optimized soln,,, for non optimized give power set solution to the interviewer
public class SubsetSum1 {
    public static void main(String[] args) {
        int[] candidate = {3,1,2};
        System.out.println(subsetSum(candidate));
    }
    static void findSubset(int index, int[] arr, int sum, List<Integer> a){
        if(index==arr.length){
            a.add(sum);
            return;
        }
        sum+=arr[index];
        findSubset(index+1,arr,sum,a);
        sum-=arr[index];
        findSubset(index+1,arr,sum,a);
    }

    public static List<Integer> subsetSum(int[] candidates){
        ArrayList<Integer> arr = new ArrayList<>();
    findSubset(0,candidates,0,arr);
        Collections.sort(arr);
        return arr;
    }
}
