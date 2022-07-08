package com.demo.LightWeightBaby.BinarySearchTree;

import java.util.ArrayList;

//https://www.codingninjas.com/codestudio/problems/normal-bst-to-balanced-bst_920472?leftPanelTab=1
//https://practice.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1/
public class NormalToBalancedBST {
    public static void main(String[] args) {
        
    }

    Node balancedBST(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root, ans); // inorder se ans array bhar lo
         
        return inOrderToBST(0, ans.size()-1, ans); // inorder se bst bana do
    }

    Node inOrderToBST(int start, int end, ArrayList<Integer> ans){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(ans.get(mid)); // mid wale element se root bna lo aur mid ke left me left recursion call right me right call
        root.left = inOrderToBST(start, mid-1, ans); //start to mid -1 is the left part
        root.right = inOrderToBST(mid+1, end, ans); // mid+1  to end is the right part
        return root;

    }

    static void inOrder(Node root, ArrayList<Integer> ans){ // storing the result of inorder traversal 
        if(root == null){
            return;
        }

        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);

    }

}
