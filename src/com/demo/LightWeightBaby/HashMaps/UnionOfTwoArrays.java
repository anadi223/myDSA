package com.demo.LightWeightBaby.HashMaps;

import java.util.HashSet;

//Question:: COunt distinct elements in two arrays
//https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1
public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1= {15,20,5,15};
        int[] arr2 = {15,15,15,20,10};

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }
        for(int j=0;j<arr2.length;j++){
            hs.add(arr2[j]);
        }
        System.out.println(hs.size());
    }
}
