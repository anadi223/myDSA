package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.BinarySerach;


//https://leetcode.com/problems/peak-index-in-a-mountain-array/

//Notes :: Q3 Binary Serach
public class PeakMountain {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1};
        int max = findPeak(arr);
        System.out.println(max + " INDEX");
    }

    public static int findPeak(int [] arr){
        int start=0;
        int end= arr.length-1;

        int mid = start + (end-start)/2;

        while(start<end){ // find the reason in notes
            if(arr[mid] <arr[mid+1]){
                start = mid+1;
            }else
                end = mid;

            mid = (start) + (end-start)/2;
        }
        return start;
    }
}
