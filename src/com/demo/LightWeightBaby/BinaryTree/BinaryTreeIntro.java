package com.demo.LightWeightBaby.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeIntro {
    public static void main(String[] args) {
        // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        Node root = null;
        root = buildTree(root);
        System.out.println("----------Printing level order--------");
        levelOrderTraversal(root);
        System.out.println("-------InOrder traversal Print -------");
        inOrderTraversal(root);
        System.out.println("-------Pre traversal Print -------");
        preOrderTraversal(root);    
        System.out.println("-------Post Order traversal Print -------");
        postOrderTraversal(root);  

    }
        //CREATE A BINARY TREE
    static Node buildTree(Node root){
        System.out.println("Enter the data");

        Scanner s1 = new Scanner(System.in);
        int data = s1.nextInt();
        root = new Node(data); //for root node
        if(data == -1){
            return null;
        }

        System.out.println("Enter data for node left "+ root.data);
        root.left = buildTree(root.left); //for left node
        System.out.println("Enter data for node right " +root.data);
        root.right = buildTree(root.right); //for right node
        return root;
    }

    // LEVEL ORDER TRAVERSAL
    static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>(); // queue ka use krna hai 
        q.add(root);
        q.add(null); // NULL ACTS AS A SEPERATOR BETWEEN LEVELS

        while(q.isEmpty() != true){ // jab tk queue empty na ho
            Node temp = q.poll();
            if(temp == null){ // jab ek level khtm ho jaaye tab next line pe jana hai
                System.out.println();

                if(q.isEmpty() != true){
                    q.add(null); //seperator between a level
                }
            }
            else{
                System.out.print(temp.data + " "); // else conditon me aaye mtlb temp is not empty koi na koi hai temp me
                if(temp.left !=null){
                    q.add(temp.left); // left wala add kar do
                }
                if(temp.right !=null){
                    q.add(temp.right); // right wala add kar do
                }
            }
        }
    }

   static void reverseLevelOrder(Node node)
    {
        Stack<Node> S = new Stack<>();
        Queue<Node> Q = new LinkedList<>();
        Q.add(node);
  
        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (Q.isEmpty() == false)
        {
            /* Dequeue node and make it root */
            node = Q.peek();
            Q.remove();
            S.push(node);
  
            /* Enqueue right child */
            if (node.right != null)
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(node.right);
                 
            /* Enqueue left child */
            if (node.left != null)
                Q.add(node.left);
        }
  
        // Now pop all items from stack one by one and print them
        while (S.empty() == false)
        {
            node = S.peek();
            System.out.print(node.data + " ");
            S.pop();
        }
    }

    static void inOrderTraversal(Node root){ // LNR
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    static void preOrderTraversal(Node root){ // NLR
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){ // LRN
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
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