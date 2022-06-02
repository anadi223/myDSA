package com.demo.basicDATASTRUCTURE.Arrays.TwoDArrays;

import java.util.Scanner;

public class PrintWaveArray {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        Scanner s1 = new Scanner(System.in);

        for(int i =0;i<2;i++){
            for(int j=0;j<2;j++){
                arr[i][j] = s1.nextInt();
            }
        }

        int n=2,m=2;
        int[] ans = printWave(arr, n, m);

        System.out.println("Printing wave array");
        for(int X: ans){
            System.out.println(X);
        }
    }

    public static int[] printWave(int[][] arr, int n, int m){

        int[] ans = new int[n*m];
        int index=0;
        for(int col = 0; col<m;col++){

            if( col%2 !=0 ){
                for(int row = n-1; row>=0;row--){
                    ans[index++] = arr[row][col];
                }
            }
                else{
                    for(int row=0;row<n;row++){
                        ans[index++]  = arr[row][col];
                    }
                }
            }

            return ans;
        }

    }

