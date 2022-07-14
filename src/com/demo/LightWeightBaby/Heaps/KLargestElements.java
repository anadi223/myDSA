package com.demo.LightWeightBaby.Heaps;


import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1/
public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {12,5,787,1,23};
        int k= 2;
        int[] ans = kLargest(arr, arr.length, k);
        reverseArray(ans); // answer chahiye tha reverse order me
        for(int x :ans){
            System.out.print(x+ " ");
        }
    }

    static int[] kLargest(int[] arr, int n, int k){ // main concept hai ye baaki toh question satisfy krne ke liye hai simple
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min Heap bna lo simple
        int[] ans = new int[k];
        for(int i =0;i<n;i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        for(int i=0;i<k;i++){
            ans[i] = minHeap.poll();
        }
        return ans;
    }

    static void reverseArray(int[] arr){
        int l =0;
        int r = arr.length-1;
        while(l <= r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
