package com.demo.LightWeightBaby.BinaryTree.TreeTraversals;

import java.util.ArrayList;




//https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1/#
public class BoundaryTraversal {
    public static void main(String[] args) {
        
    }
    ArrayList<Integer> boundary(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        ans.add(root.data); //root ka data sbse phle add krwa do
        //Traverse left part to print/store
        traverseLeft(root.left,ans);

        // Traverse leaf Node

        //Leaf node will be at left subtree and right subtree
        traverseLeaf(root.left,ans); // left sub tree ki call
        traverseLeaf(root.right, ans); // right subtree ki call

        //Traverse right part
        traverseRight(root.right, ans);

        return ans;
    }


    static void traverseLeft(Node root,ArrayList<Integer> ans){
        if(root == null){ // base case
            return;
        }
        if(root.left == null && root.right == null){ // leaf node ko exclude karna hai
            return;
        }
        ans.add(root.data); // root ke data ko store/print
        if(root.left != null){
            traverseLeft(root.left, ans); // left me hai agar data to left ki call
        }        
        else{ // right me hai data to right ka call bhai right me bhi toh left child ho skta na
            traverseLeft(root.right, ans);
        }
    }
    static void traverseLeaf(Node root, ArrayList<Integer> ans) {
        if(root == null){ // base case
            return;
        }
        if(root.left == null && root.right == null){ // leaf node condition 
            ans.add(root.data); // store/print data
            return;
        }
        traverseLeaf(root.left, ans); // left child ki call
        traverseLeaf(root.right, ans);// rifght child ki call
    }

    static void traverseRight(Node root, ArrayList<Integer> ans){
        if(root == null){  // base case
            return;
        }
        if(root.left == null && root.right == null){
            return; // leaf node ka case
        }
        if(root.right != null){ // right me jao
        traverseRight(root.right, ans);
        }
        else{
        traverseRight(root.left, ans); // warna left me jao
        }

        ans.add(root.data); // jab wapis aao toh root ko print ya store krwana hai
    }
}
