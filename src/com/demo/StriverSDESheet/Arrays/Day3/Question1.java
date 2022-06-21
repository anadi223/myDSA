package com.demo.StriverSDESheet.Arrays.Day3;

import java.util.ArrayList;

//Search in a 2D matrix
public class Question1 {
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int value = 3;
        // boolean ans = findPositionApproach1(arr, value);
        boolean ans = findPositionApproach2(arr, value);
        System.out.println(ans);
    }
    //Linear Search TC O(n 2) SC O(1)
    static boolean findPositionApproach1(int[][] arr, int value){
        boolean pos =false;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == value){
                    pos = true;
                }
            }
        }
        return pos;
    }


    //*Binary Search TC O(logmn)*/
    static boolean findPositionApproach2(int[][] arr, int value){
        int row = arr.length;
        int col = arr[0].length;
        int start=0;
        int end = (row*col)-1;

        int mid = start + (end- start)/2;

        while(start<=end){
            int element = arr[mid/col][mid%col]; // (mid/col kar rhe toh row ka index milega aur mid%col kroge toh col ka index milega)
            if(element == value){
                return true;
            }
            if(element<value){
                start = mid+1;
            }else{
                end = mid-1;
            }

            mid = start+(end-start)/2;
        }
        return false;
    }
}
