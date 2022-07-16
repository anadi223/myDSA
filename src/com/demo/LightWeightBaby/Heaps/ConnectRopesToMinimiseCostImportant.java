package com.demo.LightWeightBaby.Heaps;

import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
public class ConnectRopesToMinimiseCostImportant {
    public static void main(String[] args) {
        long arr[] = {4, 3, 2, 6};
        int n = arr.length;
        long ans = minCost(arr, n);
        System.out.println(ans);

    }

    static long minCost(long[] arr, int n){ //reason in  notes 
        PriorityQueue<Long> minHeap  = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            minHeap.add(arr[i]);
        }
        long sum=0;
        long cost=0;
        while(minHeap.size()>=2){ //>=2 kyu neeche do elements pop kar rahe hai ekdm last ke iteration me sirf total length insert hogi which will be a single element aur phir min 2 null pointer maar dega seedha aur khtm tata bye bye
            Long min1 = minHeap.poll();
            Long min2 = minHeap.poll();
            cost = cost +min1+min2;
            sum = min1+min2;
            minHeap.add(sum);
        }
        return cost;
    }
}

