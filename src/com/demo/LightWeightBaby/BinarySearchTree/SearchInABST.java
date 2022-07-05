package com.demo.LightWeightBaby.BinarySearchTree;


//https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/
public class SearchInABST {
    public static void main(String[] args) {
        
    }
    //recursive  TC O(logn) SC ~ O(n)
    static boolean findElement(Node root, int x){
        if(root == null){ // agar null hai means element nhi hai
            return false;
        }

        if(root.data == x){ // agar root ka data x ke barabar hai mtlb element mil gya
            return true;
        }

        if(x > root.data){ // left and right calls
           return findElement(root.right, x);
        }else{
           return findElement(root.left, x);
        }
    }

    //Iterative TC O(log n) SC O(1)
    static boolean findElementIterative(Node root, int x){
        Node temp = root;
        while(temp!=null){
            if(temp.data == x){
                return true;
            }
            if(x > temp.data){
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        return false;
    }
}
