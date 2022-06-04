package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar;

public class SwapAlternates {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        alternate(arr);

    }

    public static void alternate(int [] arr){
        for(int i=0;i<arr.length;i=i+2){
            if(i+1< arr.length){
                swap(arr,i,i+1);
            }else break;
        }
        for(int X : arr){
            System.out.print(X+" ");
        }
    }

    public static void swap(int[] arr ,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
