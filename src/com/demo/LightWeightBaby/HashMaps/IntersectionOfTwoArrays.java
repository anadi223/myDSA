package com.demo.LightWeightBaby.HashMaps;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {10,15,20,15,30,30,5};
        int[] arr2 = {30,5,30,80};
        int ans =  countIntersectionInTwoArraysApproach1(arr1, arr2);
        System.out.println(ans);
    }


    static int countIntersectionInTwoArraysApproach1(int[] arr1, int[] arr2){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }

        int res=0;
        for(int j=0;j<arr2.length;j++){
            if(hs.contains(arr2[j])){
                res++;
                hs.remove(arr2[j]); //  once we found that an element is present in the hashset remove it from hashset otherwise it might be possible that the other array contains that value somewhere else and result will get affected by this
            }
        }
        return res;
    }
}
