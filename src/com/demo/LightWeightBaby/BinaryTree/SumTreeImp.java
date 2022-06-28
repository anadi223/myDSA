package com.demo.LightWeightBaby.BinaryTree;

//https://practice.geeksforgeeks.org/problems/sum-tree/1
public class SumTreeImp {
    public static void main(String[] args) {
        
    }
    //TC O(n) SC O(h)
    static boolean sumTree(Node root, Sum sum){
        Sum ls = new Sum();
        Sum rs = new Sum();
        //BASE CASE
        if(root == null){
            sum.s = 0;
            return true;
        }
        //CONDITION FOR LEAF NODE
        if(root.left == null && root.right == null){
            sum.s = root.data; // jab last node me pahoch gye tab sum kya hoga left ya right ka root ka data
            return true;
        }

        boolean left = sumTree(root.left, ls); //left subtree ki call
        boolean right = sumTree(root.right, rs); // right subtree ki call
        sum.s = root.data + ls.s + rs.s;    // left sub tree right sub tree aur root node ka sum uske upr wale function call ke liye jrurt hai see recursion tree 
        boolean checkSum = (ls.s + rs.s) == root.data; // left subtree and right subtree ka sum root ke data ke barabar hona chahiyue

        if(left && right && checkSum){ // jab saari condition match hogyi toh bhaiya true return kardo
            return true;
        }else{
            return false;
        }
    }
}


class Sum{
    int s;
}