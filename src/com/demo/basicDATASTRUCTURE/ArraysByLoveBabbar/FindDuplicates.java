package com.demo.basicDATASTRUCTURE.Arrays;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDuplicates {
    public static void main(String[] args) {

    }
    public List<Integer> findDuplicates(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(!(hs.add(nums[i]))){
                al.add(nums[i]);
            }
        }
        return al;
    }
}
