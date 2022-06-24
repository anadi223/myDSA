package com.demo.LightWeightBaby.BinaryTree;

//https://www.codingninjas.com/codestudio/problems/count-leaf-nodes_893055?source=youtube&campaign=LoveBabbar_Codestudio&utm_source=youtube&utm_medium=affiliate&utm_campaign=LoveBabbar_Codestudio&leftPanelTab=0
public class CountLeafNode {
    public static void main(String[] args) {
        
    }

    static int noOfLeafNodes(Node root){
        return inOrder(root);
    }

    static int inOrder(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){ // node ka left bhi null right bhi null mtlb tm leaf node pe khde ho dost
            return 1;
        }
        return inOrder(root.left) + inOrder(root.right); // recursive call with add
    }
}
