package com.demo.LightWeightBaby.BinarySearchTree;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/submissions/
public class BSTFromPreOrder {
    public static void main(String[] args) {
        
    }


    //TC O(n) SC O(n)
    Node preOrderTOBST(int[] arr){
        int min = Integer.MIN_VALUE; // min range
        int max = Integer.MAX_VALUE; // max range
        int[] i = {0}; // by ref pass krna pdega
        return solve(arr, min, max,i);
    }


    Node solve(int[] arr ,  int min, int max,int[] i){
        if(i[0] >=arr.length){
            return null;
        }

        if(arr[i[0]] < min || arr[i[0]] > max) { // iska mtlb min and max wali range se hi bahar hai toh null return krna
            return null;
        }
        // agaar yahan tk aa gya mtlb wo element range ke andr hai 
        Node root = new Node(arr[i[0]++]); // root bna do
        root.left = solve(arr, min, root.data,i); // validate bst wala code ka logic min and max range ka
        root.right = solve(arr, root.data, max,i); // validate bst wala code ka logic

        return root;
    }
}
 