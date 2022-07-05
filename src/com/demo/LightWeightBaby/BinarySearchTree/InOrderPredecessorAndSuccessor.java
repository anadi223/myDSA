package com.demo.LightWeightBaby.BinarySearchTree;

public class InOrderPredecessorAndSuccessor {

    static Node pre;
    static Node succ;
    public static void main(String[] args) {
        

    }   
    //*ALGO */
//     1. If root is NULL
//       then return
// 2. if key is found then
//     a. If its left subtree is not null
//         Then predecessor will be the right most 
//         child of left subtree or left child itself.
//     b. If its right subtree is not null
//         The successor will be the left most child 
//         of right subtree or right child itself.
//     return
// 3. If key is smaller then root node
//         set the successor as root
//         search recursively into left subtree
//     else
//         set the predecessor as root
//         search recursively into right subtree

    static Node findPreAndSuccess(Node root, int key){
        if(root == null){
            return root;
        }
        if(root.data == key){
            if(root.left !=null){
            Node temp = root.left;
            while(temp !=null){
                temp =temp.left;
            }
            pre = temp;
        }
        }

        if(root.right != null){
            Node temp = root.right;
            while(temp !=null){
                temp = temp.right;
            }
            succ = temp;
        }

        if(root.data > key){
            pre = root;
            return findPreAndSuccess(root.left,key);
        }else{
            succ = root;
            return findPreAndSuccess(root.right, key);
        }
    }
}
