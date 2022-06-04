package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.Sorting;



//!https://www.codingninjas.com/codestudio/problems/selection-sort_981162?source=youtube&campaign=love_babbar_codestudio2&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_codestudio2
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,4213,44,55,11};
        int n = arr.length;
        sort(arr,n);

        for(int x : arr){
            System.out.println(x);
        }
    }

    static void sort(int[] arr , int n){
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }


}
