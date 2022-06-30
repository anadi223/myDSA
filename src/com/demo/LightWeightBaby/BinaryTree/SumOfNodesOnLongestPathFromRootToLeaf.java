package com.demo.LightWeightBaby.BinaryTree;


//https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
public class SumOfNodesOnLongestPathFromRootToLeaf {
    static int maxSum,maxLen; //! static variable define kiya isse reference aa jayega neechec 
    public static void main(String[] args) {
        
    }

    static int sumOfLongestPath(Node root){
        int sum =0; // current sum of a path
         maxSum = Integer.MIN_VALUE; // max sum 
        int len =0; // current length of a path
         maxLen =0; // max length/longest path


       solve(root,sum,len);
        return maxSum;
    }

    static void solve(Node root, int sum, int len){
        if(root == null){
            if(len > maxLen){ // agar current length bdi hai max length ke toh max length ko update kar do
                maxLen = len;
                maxSum = sum;
            }
            else if(len == maxLen){ // agar length barabar hai toh ek baar sum check kar lo simple 
                maxSum = Math.max(sum, maxSum);
            }
            return;
        }
        sum = sum+root.data; // sum add karte rho us current path ke liye
       solve(root.left, sum,  len+1); // left call
        solve(root.right, sum, len+1); // right call
        
    }
}
