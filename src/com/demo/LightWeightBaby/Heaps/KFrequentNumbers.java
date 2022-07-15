package com.demo.LightWeightBaby.Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Top K Frequent Numbers
//https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1/
public class KFrequentNumbers {
    public static void main(String[] args) {
        int[] arr  = {1,1,1,3,2,2,4};
        int k=2;
        int[] ans = topKFrequent(arr, k);
        for(int i:ans){
            System.out.print(i+" ");
        }

        
    }

    static int[] topKFrequent(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>(); // hashmap to store the frequency of the integers
        for(int i=0;i<arr.length;i++){ // storing the frequency of hashmap
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{

                map.put(arr[i], 1);
            }
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(); // min heap bnayaenge kyuki top pucha hai dost dekho
        for(Map.Entry<Integer,Integer> entry  : map.entrySet()){ // * NOTE ARRAY NAHI MAP TRAVERSE KAR RHE YAHAN PE 
            
            minHeap.add(new Pair(entry.getValue(), entry.getKey())); //! heap me values aise store hongi -- >> phle frequency hoga phir array ka element hoga

            if(minHeap.size() >k){
                minHeap.poll();
            }
        }

        //yhn tak min heap me answer mil jayeaga
        int[] ans = new int[k];
        int index =minHeap.size()-1;
        while(minHeap.size()>0){
            ans[index--] = minHeap.poll().arrayValue;
        }
        return ans;
    }
    
}


//Please note that since Pair class is used in some other questions as well,, and since it is under same package it will have conflict,, so easy way is to comment out any class which has pair class or simple change the name of the class
class Pair implements Comparable<Pair>{
    int frequency;
    int arrayValue;

    Pair(int frequency, int arrayValue){
        this.frequency = frequency;
        this.arrayValue = arrayValue;
    }

    @Override
    public int compareTo(Pair p){
        if(this.frequency != p.frequency){
            return this.frequency-p.frequency;
        }else{
            return this.arrayValue-p.arrayValue;
        }
    }
}
