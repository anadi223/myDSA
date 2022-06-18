package com.demo.StriverSDESheet.Arrays.Day2;

public class Question1 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] ans = rotateBy90Approach1(arr);
        rotateApproach2(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    //!TIME AND SPACE O(row*col)
    static int[][] rotateBy90Approach1(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;

        int[][] rotated = new int[row][col]; //Take dummy matrix
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                rotated[j][col-i-1] = arr[i][j]; //*Rotated matrix ka aakhri column me phle row ki value daal do */
            }
        }
        return rotated;
    }

    static void rotateApproach2(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr[0].length;j++){
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length/2;j++){
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-1-j];
                arr[i][arr.length-1-j] = temp;
            }
        }
    }

}
