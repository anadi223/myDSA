package com.demo.LightWeightBaby.BinaryTree;


//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class CheckForBalancedTree {
    public static void main(String[] args) {
        
    }
    // TC O9n2)
    static boolean isBalancedApproach1(Node root){
        if(root == null){
            return true;
        }

        boolean left = isBalancedApproach1(root.left);
        boolean right = isBalancedApproach1(root.right);

        boolean height = Math.abs(height(root.left) - height(root.right)) <=1;
        if(left && right && height){
            return true;
        }else{
            return false;
        }
    }
    static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right) + 1;
     }

     //* TIME COMPLEXITY O(N) */
     static boolean isBalancedApproach2(Node root,Height height){
        Height lh = new Height();
        Height rh  = new Height();
        if(root == null){
            height.h =0;
            return true;
        }
       
        boolean left = isBalancedApproach2(root.left, lh);
        boolean right = isBalancedApproach2(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;

        boolean heightAns = Math.abs(lh.h - rh.h) <=1;

        if(left && right && heightAns){
            return true;
        }
        else{
            return false;
        }
     }
}


class Height{
    int h;

}