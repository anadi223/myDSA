package com.demo.StriverSDESheet.Arrays.Day3;

//https://leetcode.com/problems/unique-paths/
//GRID UNIQUE PATHS
public class Question5 {
    public static void main(String[] args) {
        
    }

    //int m n are matrix m*n
    static int uniquePathsApproach1(int m, int n){
        //base case
        return countPaths(0, 0, m, n);
    }

    static int countPaths(int i, int j, int m, int n){ //i -- bottom ,, j -- right
        if(i==(m-1) && j==(n-1)) // agar dono values boundary ke andr hai toh nice
        return 1;

    if(i>=m || j>=n){
        return 0;
    }
    else return countPaths(i+1, j, m, n) + countPaths(i, j+1, m, n);
    }
}
