package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        
        int arr1[] = {1,3,5,7,9};
        int n = arr1.length;
        int arr2[]  ={2,4,6};
        int m = arr2.length;
        int arr3[] = new int[n+m];
    
        merge(arr1, n, arr2, m, arr3);

        for(int X: arr3){
            System.out.println(X);
        }

    }
    
    public static void merge(int[] arr1, int n , int[] arr2, int m,int[] arr3){

        int i=0,j=0,k=0; // k hai 3rd array ka index

        while(i<n && j<m){
            if(arr1[i] <arr2[j]){
                arr3[k++] = arr1[i++];
            }
            else{
                arr3[k++] = arr2[j++];
            }
        }


        //! Copying the 1st array if remaining anything
        while(i<n){
            arr3[k++] = arr1[i++];
        }

        //*Copying the 2nd arry if remaining anything
        while(j<m){
            arr3[k++] = arr2[j++];
        }

    }
}
