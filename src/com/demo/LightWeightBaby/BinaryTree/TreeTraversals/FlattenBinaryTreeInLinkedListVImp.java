package com.demo.LightWeightBaby.BinaryTree.TreeTraversals;


//https://practice.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1/
public class FlattenBinaryTreeInLinkedListVImp {
    public static void main(String[] args) {
        
    }
    //algo written in notes
    //TC O(n) SC O(1)
    void flat(Node root){
        Node curr = root;

        while(curr != null){
            if(curr.left !=null){
                Node predecssor = curr.left;
                while(predecssor.right !=null){
                    predecssor = predecssor.right;
                }
                predecssor.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }

        //left part ko null kar do Stated in question --> left of each part should point to null
        curr = root;
        while(curr !=null){
            curr.left = null;
            curr = curr.right;
        }
    }
}
