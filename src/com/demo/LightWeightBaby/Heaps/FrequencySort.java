package com.demo.LightWeightBaby.Heaps;

//https://leetcode.com/problems/sort-array-by-increasing-frequency/submissions/
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,3,2};
        int[] ans = frequencySort(arr);
        for(int i :ans){
            System.out.print(i+" ");
        }
    }

    static int[] frequencySort(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>(); // frequency store krwa liya har element ka
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        PriorityQueue<Help> maxHeap = new PriorityQueue<Help>(Collections.reverseOrder()); // max heap bnaya hai kyuki max frequency wala phle aana hai
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(new Help(entry.getValue(), entry.getKey()));
        }

        int[] ans = new int[arr.length];
        int index = ans.length-1;
        while(maxHeap.size()>0){
            int freq = maxHeap.peek().first;
            int element = maxHeap.peek().second;
            maxHeap.poll();
            for(int i=1;i<=freq;i++){
                ans[index--] = element;
            }
        }
        return ans;
    }
}



class Help implements Comparable<Help>{
    int first;
    int second;
    Help(int first, int second){
        this.first = first;
        this.second = second;
    }

    public int compareTo(Help h){
        if(this.first!= h.first){
            return this.first-h.first;
        }
        else{
            return h.second-this.second; // ye diya hai question me ki jo value bdi hogi wo phle aayegi is liye h.second - this.second kiya
        }
    }
}