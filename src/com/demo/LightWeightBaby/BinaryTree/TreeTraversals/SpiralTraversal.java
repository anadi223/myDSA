package com.demo.LightWeightBaby.BinaryTree.TreeTraversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SpiralTraversal {
    public static void main(String[] args) {
        
    }

    static ArrayList<Integer> zigZagTraversal(Node root){
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null){ 
            return ans;
        }

        Queue<Node> q = new LinkedList<>();  // USing level order traversal means queue
        q.add(root);

        boolean leftToRight = true; // ye btayega ki left to right jana hai ki right to left jana hai

        while(q.isEmpty() == false){
            int size = q.size();
            int[] temp  = new int[size]; // temp array jo har level ka data store karega

            for(int i=0;i<size;i++){
                Node front = q.poll(); // element nuikalo
 
                 int index = leftToRight ? i : size-i-1; // ye basically bta rha ki left to right insert karna hai ki right to left insert krna hai
                temp[index] = front.data;

                if(front.left !=null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }
            leftToRight = !leftToRight; // saari process ke baad next level me change ho jayega direction 

            for(var i : temp){
                ans.add(i); // final list me ans add kar do
            }
        }
        return ans;
    }
}


class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}