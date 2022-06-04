package com.demo.basicDATASTRUCTURE.Arrays.TwoDArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://leetcode.com/problems/spiral-matrix/
public class SpiralPrint {
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);

        System.out.println("Enter elements");
        int[][] arr = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
            arr[i][j] = s1.nextInt();
            }
        }

        List<Integer> ans  = printSpiral(arr);
        System.out.println("ANSWER");
        System.out.println(ans);
    }


    public static List<Integer> printSpiral(int[][] arr){
    
        int row = arr.length;
        int col = arr[0].length;

        int count=0; //monitor the total element
        int total=row*col; //total no of element

        List<Integer> ans = new ArrayList<>();



        //indexes of all the sides of the matrix
        int startingRow=0;
        int startingCol=0;
        int endingRow= row-1;
        int endingCol = col-1;

        //agar total element se hi bda hogya count to dost traverse kya kroge
        while(count<total){


            //*Print Starting Row */
        for(int i=startingCol;i<=endingCol && count<total;i++){  //! count<total kyu kiya because while traversing in for loop agar total element se bda hogya count to duplicate print krwa doge bhai tum in every case
            ans.add(arr[startingRow][i]);
            count++;
        }
        startingRow++; // agle row ko starting row bnana hai because next time hmko agli row chahiye agar nhi kroge ye toh wapis se jo row traverse krke print krwaye ho whi aa jeyagi for every case(col and row)
        
         //*Print Ending Col */
        for(int i=startingRow;i<=endingRow && count < total ; i++){
            ans.add(arr[i][endingCol]);
            count++;
        }
        endingCol--;

         //*Print Ending Row */
        for(int i=endingCol;i >=startingCol && count<total ; i--){
            ans.add(arr[endingRow][i]);
            count++;
        }
        endingRow--;

         //*Print Starting Col */
        for(int i=endingRow; i>= startingRow && count<total; i--){
            ans.add(arr[i][startingCol]);
            count++;
        }

        startingCol++;
        }
        return ans;
    }
    
}
