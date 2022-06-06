package com.demo.StriverSDESheet.Arrays;


//https://leetcode.com/problems/set-matrix-zeroes/
public class Question1 {
     public static void main(String[] args) {
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
     }


     //!Brute Force Time Complexity :: O(n*m) + O(n+m) Space : O(1)
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


}
