package com.demo.basicDATASTRUCTURE.Arrays.TwoDArrays;

import java.util.Scanner;

public class RowWiseSum {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        Scanner s1 = new Scanner(System.in);

        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = s1.nextInt();
            }
        }
        int n=3;
        int m =3;

        sum(arr, n, m);

    }

    static void sum(int[][] arr, int n, int m){
        for(int  i=0;i<n;i++){
            int sum=0;
            int temp=0;
            int rowIndex=-1;
            for(int j=0;j<m;j++){
                sum += arr[i][j];
            }
            if(sum > temp){
                temp = sum;
                rowIndex=i;
            }
            
            System.out.println(sum + "  Sum of " +i + " row");
            System.out.println(" MAX SUM ROW IS " + rowIndex);
        }
    }
}
