package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.TwoDArrays;

import java.util.Scanner;

public class BasicInputOutput {
    public static void main(String[] args) {
        

        int[][] arr = new int[3][3];

        Scanner s1 = new Scanner(System.in);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print("Add new entry");
                arr[i][j] = s1.nextInt();
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
