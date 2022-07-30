package com.demo.LightWeightBaby.BinaryTree.TreeTraversals;

//HELPER CLASS FOR ALL OTHER CLASS
public class Node {
    int data;
    Node left;
    Node right;
    Node(){}
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
