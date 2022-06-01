package com.demo.basicDATASTRUCTURE.Arrays.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {10,1,4,14,7};
        insertionSort(arr);
        for(int x : arr){
            System.out.println(x);
        }
    }


    static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j = i-1;

            for(; j>=0;j--){

                if(arr[j] > temp){
                    
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]  = temp;
        }
    }

    static void insertionSort2(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j = i-1;

            for(; j>=0;j--){

                if(arr[j] > temp){
                    
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]  = temp;
        }
    }

}
