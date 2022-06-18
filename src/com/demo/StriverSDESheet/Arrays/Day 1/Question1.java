package com.demo.StriverSDESheet.Arrays;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/
public class Question1 {
     public static void main(String[] args) {
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        // setZeroes(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

       

        // setZeroesBetterApproach(arr);
        // System.out.println("BEtter approch called-----------");
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        optimizedApproach(arr);
        System.out.println("Optimized approch called-----------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

     }


     //!Brute Force Time Complexity :: O(n*m) + O(n+m) Space : O(1) Tab hi kaam aayega jab koi bhi element matrix me phle se -1 na ho
     static void setZeroes(int[][] arr){
         int row = arr.length;
         int col = arr[0].length;

         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){

                 if(arr[i][j] ==0){

                    int index = i-1; // current column position ke upr wale elements ko zero
                    while(index >=0){
                        if(arr[index][j] !=0){
                            arr[index][j] =-1;
                        }
                        index--;
                    }

                    index = i+1; //current column position ke neeche wale elements ko zero
                    while(index<row){
                        if(arr[index][j] !=0){
                            arr[index][j] =-1;
                        }
                        index++;
                    }

                    index = j-1; //current row position ke upr wale elements ko zero
                    while(index >=0){
                        if(arr[i][index] !=0){
                            arr[i][index] =-1;
                        }
                        index--;
                    }
                    index = j+1; //current row position ke neeche wale elements ko zero
                    while(index < col){
                        if(arr[i][index] !=0){
                            arr[i][index] = -1;
                        }
                        index++;
                    }
                 }
             }
         }

         for(int i=0;i<row;i++){ // jo jo element ko -1 bnaya hai usko wapis se zero bna do
             for(int j=0;j<col;j++){
                 if(arr[i][j] <=0){
                     arr[i][j] =0;
                 }
             }
         }

     }


     //* Better Solution With Time complexity O(n*m + n*m) And Space = O(n) + O(m) */

     static void setZeroesBetterApproach(int[][] arr){
         int rows=arr.length;
         int cols = arr[0].length;
         int[] dummy1 = new int[rows];
         int[] dummy2 = new int[cols];
         Arrays.fill(dummy1, -1);
         Arrays.fill(dummy2, -1);

         for(int i=0;i<rows;i++){
             for(int j=0;j<cols;j++){
                 if(arr[i][j] ==0){
                     dummy1[i] =0;
                     dummy2[j] =0;
                 }
             }
         }

         for(int i=0;i<rows;i++){
             for(int j=0;j<cols;j++){
                 if(dummy1[i] ==0 || dummy2[j] ==0){
                     arr[i][j] = 0;
                 }
             }
         }

     }

     //! OPTIMIZED APPROACH O(2*(N*M)) SPACE O(1)
     static void optimizedApproach(int[][] arr){
         int col0=1;
         int row=arr.length;
         int col =arr[0].length;

         for(int i=0;i<row;i++){
             if(arr[i][0] ==0) {
             col0=0;
            }

             for(int j=1;j<col;j++){
                 if(arr[i][j] ==0){
                     arr[i][0] = arr[0][j] =0;
                 }
             }
         }

         for(int i=row-1;i>=0;i--){
             for(int j=col-1;j>=1;j--){
                 if(arr[i][0] ==0 || arr[0][j]==0){
                     arr[i][j] =0;
                 }
                 
             }
             if(col0==0){
                arr[i][0] =0;
            }
         }

     }



}
