package com.demo.basicDATASTRUCTURE.Arrays.BinarySerach;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/codestudio/problems/allocate-books_1090540
public class BookAllocationProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(10,20,30,40));
        int m=2;
        int n = arr.size();
        int ANS = allocateBook(arr,n,m);
        System.out.println(ANS);
    }

    public static int allocateBook(ArrayList<Integer> arr, int n , int m){

        int start =0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr.get(i);
        }
        int end = sum;
        int mid  = start+(end-start)/2;
        int ans=-1;
        while(start<=end){
            if(isPossibleSolution(arr,n,m,mid)){
                ans= mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            mid = start+ (end-start)/2;
        }
        return ans;
    }

    static boolean isPossibleSolution(ArrayList<Integer> arr, int n, int m, int mid){
        int studentCount=1;
        int pageSum=0;

        for(int i=0;i<n;i++){
            if(pageSum+ arr.get(i) <= mid){
                pageSum+=arr.get(i);
            }
            else{
                studentCount++;
                if(studentCount > m || arr.get(i) > mid){
                    return false;
                }
                pageSum =arr.get(i);
            }
        }
        return true;
    }

}
