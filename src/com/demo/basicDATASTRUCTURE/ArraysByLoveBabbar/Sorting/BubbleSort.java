package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,22,11,44,55};
        bubbleSort(arr,arr.length);
        for(int x : arr){
            System.out.println(x);
        }
    }

    public static void bubbleSort(int[] arr, int n) {
        for(int i=1;i<n;i++){
            for(int j=0;j<n-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
