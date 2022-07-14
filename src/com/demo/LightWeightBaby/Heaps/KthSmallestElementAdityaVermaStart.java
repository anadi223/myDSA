package com.demo.LightWeightBaby.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementAdityaVermaStart {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        int ans = findKthSmallest(arr, k);
        System.out.println(ans);
    }
    //https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1/
    static int findKthSmallest(int[] arr, int k){
        int size = arr.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //max heap bnao

        for(int i=0;i<size;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k){ // agar k se jyada ho jaaye toh pop kar do
                maxHeap.poll();
            }
        }
        return maxHeap.peek(); // jab saare elements traverse ho jayenge aur pop ho jayenge toh top pe jo element hoga that will be the Kth smallest element
    }
}
