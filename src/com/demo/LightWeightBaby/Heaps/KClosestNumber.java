package com.demo.LightWeightBaby.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/k-closest-elements3619/1/
public class KClosestNumber {
    public static void main(String[] args) {
        int[] arr = {12, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55, 56};
        int k=4;
        int x = 35;
        int[] ans = findKClosest(arr, x, k);
        for(int a: ans){
            System.out.print(a+" ");
        }
    }

    static int[] findKClosest(int[] arr,  int x, int k){
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            if(x == arr[i]) continue; // question me diya hai ki X ko include nhi krna hai answer me
            maxHeap.add(new Pair((Math.abs(x - arr[i])),arr[i]));
            if(maxHeap.size()> k){
                maxHeap.poll();
            }
        }
        //is step tak maxHeap me wo values hongi jo answer me chhaiye see notes
        int[] ans = new int[k]; 
        int index=maxHeap.size()-1;
        while(maxHeap.size()>0){
            ans[index--] = maxHeap.poll().second;
        }
        return ans;
    }

}


class Pair implements Comparable<Pair>{
    int first; // this is key
    int second; // this is the value

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair p){ //compareTo is a method used to compare two values based on some parameters 
        if(this.first != p.first){ //for our question agar phli value dusri se equal nhi hai
            return this.first - p.first; //toh sort based on the difference on the values
        }else{
            return p.second - this.second; // agar same hai dono firsts toh ek kaam karo dost second ke basis pe calculate kar lo
        }
     }
    
}
