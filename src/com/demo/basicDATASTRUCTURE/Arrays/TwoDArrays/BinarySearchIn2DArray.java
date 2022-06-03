package com.demo.basicDATASTRUCTURE.Arrays.TwoDArrays;

import java.util.Scanner;

public class BinarySearchIn2DArray {
   // https://leetcode.com/problems/search-a-2d-matrix
    public static void main(String[] args) {
        int[][] arr = new int[3][4];


        //[[1,3,5,7],[10,11,16,20],[23,30,34,60]
        Scanner s1 = new Scanner(System.in);
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                arr[i][j] = s1.nextInt();
            }
        }

        s1.close();

        int target=60;

        boolean ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    public static boolean binarySearch(int[][] arr, int target){

        int row = arr.length;
        int col = arr[0].length;

        int start = 0;
        int end = (row * col) -1;

        int mid = (start)+ (end-start)/2;

        while(start<=end){

            int element = arr[mid/col][mid%col]; // index chahiye hmko element ka kaise refer notes

            if(element == target){
                return true;
            }


            if(element < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }

            mid = (start) + (end-start)/2;
        }

        return false;
    }
    
}
