package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.BinarySerach;

import java.util.ArrayList;
import java.util.List;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(List.of(7,9,1,2,3));
        int key = 9;
        int n = arr.size();
        int pivot = findPivot(arr);
        System.out.println("************************"+pivot);

        int position = findPosition(arr,n,key);
        System.out.println(position);
    }
    public static int findPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.

        int pivot  = findPivot(arr);
        if(k>=arr.get(pivot) && k<= arr.get(n-1)){
            return binarySearch(arr,pivot,n-1,k);
        }else
            return binarySearch(arr,0,pivot-1,k);

    }

    static int findPivot(ArrayList<Integer> arr){
        int start = 0;
        int end = arr.size()-1;

        int mid = start + (end -start)/2;

        while(start<end){
            if(arr.get(mid) >= arr.get(0)){
                start = mid+1;
            }
            else{
                end = mid;
            }

            mid = start + (end- start)/2;
        }
        return start;
    }
    static int binarySearch(ArrayList<Integer> arr, int start, int end, int key){

        int mid = start+ (end - start)/2;

        while(start<=end){
            if(arr.get(mid) == key){
                return mid;
            }
             if(arr.get(mid)<key){
                start = mid+1;
            }else{
                end = mid-1;
             }
             mid = start+ (end - start)/2;
        }
        return -1;
    }



}



