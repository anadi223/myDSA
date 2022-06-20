package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.Sorting;


//https://www.codingninjas.com/codestudio/problems/merge-sort_920442?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_14
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,3,4,1,9};
        mergeSort(arr, 0, arr.length-1);

        for(int x: arr){
            System.out.print(x+ " ");
        }

    }


    static void mergeSort(int[] arr, int start, int end){

        if(start>=end){
            return;
        }
        int mid = start+ (end-start)/2;
        //for left part sort 
        mergeSort(arr, start, mid);

        // for right part sort
        mergeSort(arr, mid+1, end);

        merge(arr,start,end); // merge call karo
    }

    static void merge(int[] arr, int start, int end){

        int mid = start+ (end-start)/2;

        int len1 = mid-start+1; //length of first array before mid
        int len2 = end -mid; // length of second array after mid 

        int[] first = new int[len1]; 

        int[] second = new int[len2];

        //Copy the values of sorted divided into two arrays in each newly created arrays
        //so basically we are creating two arrays left and right jo upar kiya hai sort uska alag alag array bana lo
        int mainArrayIndex=start;
        for(int i=0;i<len1;i++){
            first[i] = arr[mainArrayIndex++];
        }
        mainArrayIndex = mid+1;
        for(int i=0;i<len2;i++){
            second[i] = arr[mainArrayIndex++];
        }

        //Now merge two sorted array 

        int index1 = 0,index2 =0;
        mainArrayIndex=start;

        while(index1<len1 && index2< len2){
            if(first[index1] < second[index2]){
                arr[mainArrayIndex++] = first[index1++];
            }else{
                arr[mainArrayIndex++] = second[index2++];
            }
        }

        while(index1<len1){
            arr[mainArrayIndex++]  = first[index1++];
        }
        while(index2<len2){
            arr[mainArrayIndex++]  = second[index2++];
        }
    }
}
