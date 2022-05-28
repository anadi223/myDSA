package com.demo.basicDATASTRUCTURE.Arrays.BinarySerach;
//https://www.codingninjas.com/codestudio/problems/allocate-books_1090540
public class BookAllocationProblem {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int m=2;
        int n = arr.length;

        BookAllocationProblem bp = new BookAllocationProblem();
        int ANS = bp.allocateBook(arr,n,m);
        System.out.println(ANS);
    }

    public int allocateBook(int[] arr, int n , int m){

        int start =0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
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

    boolean isPossibleSolution(int[] arr, int n, int m, int mid){
        int studentCount=1;
        int pageSum=0;

        for(int i=0;i<n;i++){
            if(pageSum+ arr[i] <= mid){
                pageSum+=arr[i];
            }
            else{
                studentCount++;
                if(studentCount > m || arr[i] > mid){
                    return false;
                }
                pageSum =arr[i];
            }
        }
        return true;
    }

}
