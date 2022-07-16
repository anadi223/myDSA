package com.demo.LightWeightBaby.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1
public class SumOfElementsBetweenK1K2Smallest {
    public static void main(String[] args) {
        long[] arr = {20, 8, 22, 4, 12, 10, 14};
        long k1 = 3;
        long k2 = 6;
        long ans = sumBetweenK1AndK2Smallest(arr, k1, k2);
        System.out.println(ans);
    }

    static long sumBetweenK1AndK2Smallest(long[] arr, long k1, long k2){
        long small1 = findKthSmallest(arr, k1);
        long small2 = findKthSmallest(arr, k2);

        long sum =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]> small1 && arr[i] < small2){
                sum+=arr[i];
            }
        }
        return sum;
    }

    static long findKthSmallest(long[] arr, long k){
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
