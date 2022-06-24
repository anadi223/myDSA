package com.demo.LightWeightBaby.BinaryTree;

//https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
public class HeightOfBinaryTree {
    public static void main(String[] args) {
        
    }

    //TC O(n) SC O(H) 
    int heightOfTree(Node root){
        if(root == null){
            return 0;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        return Math.max(left, right) + 1; // left aur right subtree ka max +1 (1 kya hai root element )

    }


}
