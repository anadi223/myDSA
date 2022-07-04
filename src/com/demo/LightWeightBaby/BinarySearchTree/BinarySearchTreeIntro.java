package com.demo.LightWeightBaby.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeIntro {
    public static void main(String[] args) {
        Node root = null;
        System.out.println("Enter data to create BST");
        root = takeInput(root);

        System.out.println("PRinting BST");
        levelOrderTraversal(root);
    }


    static Node takeInput(Node root){
        Scanner s1 = new Scanner(System.in);
        int data = s1.nextInt();

        while(data != -1){ // jab tak data -1 nhi aa jata tab tak insert karte rho input le le ke
            root = insertIntoBST(root,data);
            data = s1.nextInt();
        }
        return root;
    }
    //BST INSERTION TC (OLOGN)
    private static Node insertIntoBST(Node root, int data) {
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data > root.data){
            //right part me insert krna krna hai
            root.right = insertIntoBST(root.right, data);
        }else{
            //left part me insert
            root.left = insertIntoBST(root.left, data);
        }
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
        //Inorder same as Binary Tree
        static void inOrderTraversal(Node root){ // LNR
            if(root == null){
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    //PreOrder same as Binary Tree
        static void preOrderTraversal(Node root){ // NLR
            if(root == null) return;
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    //PostOrder same as Binary Tree
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
