package com.demo.LightWeightBaby.Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1/#
public class KNearlySortedArrayImp {
    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        int k =3;
        ArrayList<Integer> ans = nearlySorted(arr, arr.length, k);
        for(int x : ans){
            System.out.print( x + " ");
        }
    }

    static ArrayList<Integer> nearlySorted(int[] arr, int n, int k){
        ArrayList<Integer> ans  = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return ans;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap liya kyuki hmko phle element me min value dalna hai
     
        for(int i=0;i<=k;i++){
            minHeap.add(arr[i]); // first k elements ko heap me daal diya
        }

        for(int i=0;i<n-k-1;i++){ // loop chlega 7-3-1 = 3 kyu hme har element ko k window me process krna hai right
            arr[i] = minHeap.poll(); // phle array update kar diya
            minHeap.add(arr[i+k+1]); // min heap me suppose for first iteration i =0 toh  0+3+1 = 4th index wala value add kar do array me
        }

        int i = arr.length - k-1 ;  // 7-3-1 = 3 element abhi bhi heap me honge usko wapis se dalna hai arry me
        while(minHeap.size()>0){
            arr[i] = minHeap.poll();
            i++;
        }

        for(int j : arr){ // answer me arary list was return type soo
            ans.add(j);
        }
        
        return ans;
    }
}
