package com.demo.LightWeightBaby.Heaps;

//https://leetcode.com/problems/k-closest-points-to-origin/
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        
    }

    static int[][] kClosestPoints(int[][] arr,int k){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1])); //max heap bnaya
        
        for(int[] point: arr){
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = maxHeap.poll();
        }
        return ans;
    }
}


