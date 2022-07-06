package com.demo.LightWeightBaby.BinarySearchTree;

public class ValidBST {
    public static void main(String[] args) {
        
    }
    //https://practice.geeksforgeeks.org/problems/check-for-bst/1/#
    static boolean validateBST(Node root){

        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); // as infinty toh likh nhi skte naa
    }

    //TC O(n) SC O(n)
    static boolean isBST(Node root,int min, int max){
        if(root == null){
            return true;
        }

        if(root.data > min && root.data <max){ // har ek node ke liye ye condition check honi chahiye
            boolean left = isBST(root.left, min, root.data); // left call reason in notes
            boolean right = isBST(root.right, root.data, max);
            return left && right;
        }

        else
            return false;
    }
}
