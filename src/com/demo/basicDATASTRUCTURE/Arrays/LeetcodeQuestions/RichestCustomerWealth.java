package com.demo.basicDATASTRUCTURE.Arrays.LeetcodeQuestions;

import java.util.Scanner;

//https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] arr = new int[3][2];

        Scanner s1 = new Scanner(System.in);

        for(int i =0;i<3;i++){
            for(int j=0;j<2;j++){
                arr[i][j] = s1.nextInt();
            }
        }

        int answer = wealthSum(arr);
        System.out.println(answer);
    }

    public static int wealthSum(int[][] arr){

        int row = arr.length;
        int col = arr[0].length;

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            int sum=0;
            
            for(int j=0;j<col;j++){
               
                sum+= arr[i][j];
            }
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;
        
    }

}
