package com.demo.LightWeightBaby.BinaryTree;

//https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

public class DiameterOfABinaryTree {
    public static void main(String[] args) {
        
    }
    // TC O(n2) 
    static int diameter(Node root){
        if(root == null) {
            return 0;
        }   

        int opt1 = diameter(root.left);
        int opt2 = diameter(root.right);
        int opt3 = height(root.left) + 1 + height(root.right);
        int ans = Math.max(opt1, Math.max(opt2, opt3));
        return ans; 
     }
     static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right) + 1;
     }


     //&OptimizedApproach   TC O(n)
     static int diameterApproach2(Node root,Height height){
        Height lh = new Height();  // left tree ki height
        Height rh = new Height(); // right tree ki height

        if(root == null){
            height.h =0; 
            return 0;
        }

        int leftDiameter = diameterApproach2(root.left, lh); // left diamter wali call me height aur diamter saath me aa jayega
        int rightDiameter = diameterApproach2(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1; // height nikalne ka formula

        return Math.max(lh.h+rh.h, Math.max(leftDiameter, rightDiameter)); 


     }
     
    }

//A HELPER CLASS SINCE WE DONT HAVE PAIR METHOD LKIKE C++ (hai dusri library import krni pdegi)
class Height{
    int h;
}