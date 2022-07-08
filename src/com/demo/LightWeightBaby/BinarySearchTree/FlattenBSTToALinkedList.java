package com.demo.LightWeightBaby.BinarySearchTree;

import java.util.ArrayList;
//https://www.codingninjas.com/codestudio/problems/flatten-bst-to-a-sorted-list_1169459?leftPanelTab=1
public class FlattenBSTToALinkedList {
    public static void main(String[] args) {
        
    }

    static Node flattenAList(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root,ans);

        Node newRoot = new Node(ans.get(0)); // ek naya root bnao jisko return krenge
        Node curr = newRoot; // curr node traverse krne ke liye
        int n = ans.size();
        for(int i=1;i<n;i++){
            Node temp = new Node(ans.get(i)); // ek temp node
            curr.left = null; // left ko null
            curr.right = temp; // right ko temp mtlb har node ko uske aage wale node pe point
            curr = temp; // curr ko aage bdha do
        }

        //3rd step last node ke left right ko null
        curr.left = null;
        curr.right = null;

        return newRoot;

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
