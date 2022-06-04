package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.BinarySerach;

public class SquareRootUsingBinarySearch {
    public static void main(String[] args) {
        int n =36;
        int square = findSquare(n);
        System.out.println(square);
        long i = Long.MIN_VALUE;
    }

    static int findSquare(long n){

        int s=0;
        int e= (int) n;

        long mid = (s+e)/2;
        int ans=-1;

        while(s<=e){
            long square = (long) mid *mid;
            if(square == n){
                return (int) mid;
            }
            if(square<n){
                s = (int) (mid+1);
                ans = (int) mid;
            }
            else{
                e = (int) (mid-1);
            }
            mid = (s+e)/2;
        }
        return -1;
    }
}
