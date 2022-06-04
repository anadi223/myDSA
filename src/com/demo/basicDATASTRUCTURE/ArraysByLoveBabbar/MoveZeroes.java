package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {4,0,5,0,8,0};
        moveZeroes(arr);

        for(int x: arr){
            System.out.print(x+" ");
        }
    }
    
    static void moveZeroes(int[] arr){
        int i=0;

        for(int j=0;j<arr.length;j++){
            if(arr[j] != 0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                i++;
            }
        }
    }
}
