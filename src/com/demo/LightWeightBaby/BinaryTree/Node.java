package com.demo.LightWeightBaby.BinaryTree;

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
