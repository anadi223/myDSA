package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.BinarySerach;

public class BinarySearchImplementation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int key = 5;
        int index = binarySearchRecursive(arr, 0, arr.length - 1, key);
        int index2 = binarySearchIterative(arr, 0, arr.length - 1, key);
        System.out.println(index);
        System.out.println(index2);
    }


    static int binarySearchIterative(int[] arr,int l,int r, int key){

        int mid = (l+r)/2;

        while(l<=r){
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] < key){
                l = mid+1;
            }else
                r= mid-1;

            mid = (l+r)/2;
        }
        return -1;
    }

    static int binarySearchRecursive(int[] arr, int l, int r, int key) {
        if (r >= l) {
            int mid = (l + r) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                return binarySearchRecursive(arr, l, mid - 1, key);
            } else {
                return binarySearchRecursive(arr, mid + 1, r, key);
            }
        }
        return -1;
    }
}
