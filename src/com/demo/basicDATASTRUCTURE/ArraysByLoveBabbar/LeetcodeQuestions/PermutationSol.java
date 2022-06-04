package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.LeetcodeQuestions;


//https://leetcode.com/problems/build-array-from-permutation/
public class PermutationSol {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        int[] ans = buildPermutation(nums);

        for(int x : ans){
            System.out.println(x);
        }

    }

    public static int[] buildPermutation(int[] nums){

        int[] arr = new int[nums.length];
        int index =0;
        for(int i=0;i<nums.length;i++)
        {
            arr[index++] = nums[nums[i]];
        }
        return arr;
    } 

}
