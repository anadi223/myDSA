package com.demo.basicDATASTRUCTURE.Arrays.TwoDArrays;

import java.util.Scanner;

public class LinearSerachInTwoD {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        Scanner s1 = new Scanner(System.in);

        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = s1.nextInt();
            }
        }

        int n=3;
        int m=3;
        int target = 1;
        boolean answer = linearSearch(arr, target, n, m);
        System.out.println("Present or Not " + answer);

    }
    
    static boolean linearSearch(int[][] arr, int target, int n, int m){

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }
}
