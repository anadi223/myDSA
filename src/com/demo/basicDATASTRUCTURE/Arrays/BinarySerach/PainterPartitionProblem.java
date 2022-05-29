package com.demo.basicDATASTRUCTURE.Arrays.BinarySerach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PainterPartitionProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(5,5,5,5));
        int k = 2;
        int minPartition = findPartition(arr,k);
        System.out.println(minPartition);
    }

    static int findPartition(ArrayList<Integer> arr, int k) {
        int start = 0;
        int sum = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
        }

        int end = sum;
        int mid = start + (end - start) / 2;
        int ans = -1;
        while (start <= end) {
            if (isPossiblePartition(arr, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }

    static boolean isPossiblePartition(ArrayList<Integer> arr , int k, int mid){
        int n = arr.size();
        int painterCount=1;
        int partitionSizeSum=0;
        for(int i=0;i<n;i++){
            if(partitionSizeSum+arr.get(i)<=mid){
                partitionSizeSum+= arr.get(i);
            }
            else{
                painterCount++;
                if(painterCount > k || arr.get(i) >mid){
                    return false;
                }
                partitionSizeSum = arr.get(i);
            }
        }
        return true;
    }
}
