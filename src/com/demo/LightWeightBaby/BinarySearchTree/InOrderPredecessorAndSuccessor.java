package com.demo.LightWeightBaby.BinarySearchTree;

//https://www.codingninjas.com/codestudio/problems/_893049?topList=love-babbar-dsa-sheet-problems&leftPanelTab=1
public class InOrderPredecessorAndSuccessor {

    public static void main(String[] args) {
        

    }   

    //Predecessor :: LEFT SUBTREE ME MAXIMUM ELEMENT HOGA
    //Successor :: Right SUBTREE ME MINIMUM ELEMENT 
    //to find min element left left left
    // to find max element right right right

    //ALGO:: Node find karo
    // min/max wali logic se pred and succ 
    //tc o(N) sc O(N)
    static Pair predecessorSuccessor(Node root, int key){
     
        //find key
        Node temp = root;
        int pre =-1;
        int succ = -1;
        while(temp.data !=key){
            if(temp.data > key){ // mai aise node pe hu jiska data key se bda hai toh mereko temp ko left part me leke jana pdega 
                succ = temp.data;
                temp = temp.left; // jahan mai currently kdha tha toh ye possible successor ho skta
                
            }else{
                pre = temp.data;// jahan mai currently kdha tha toh ye possible predecessor ho skta
                temp = temp.right;// mai aise node pe hu jiska data key se chota hai toh mereko temp ko right part me leke jana pdega 
            }
        }
        //pred and succ
        //find pred hmesha left subtree me hone wala hai aisa kyu aree bhai 1 2 3 toh 2 ka pred kya hai 1 aur 1 BST me kidhr hoga left me hoga
        Node leftTree = temp.left;
        while(leftTree != null){
            pre = leftTree.data; // ans save krwa rhe har step pe jab tak ekdm right na pahoch jaaye
            leftTree = leftTree.right; // *IMPORTANT STEP *predecessor is the maximum value in the left subtree and max nikalte hai and max is at the right most part of the tree
        }

        //succ
        Node rightTree = temp.right;
        while(rightTree !=null){
            succ = rightTree.data;// ans save krwa rhe har step pe jab tak ekdm right na pahoch jaaye
            rightTree = rightTree.left;// *IMPORTANT STEP *successor is the minimunm value in the right subtree and min nikalte hai and min is at the left most part of the tree
        }
        Pair pair = new Pair(pre, succ);
        return pair;
    }
}

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}