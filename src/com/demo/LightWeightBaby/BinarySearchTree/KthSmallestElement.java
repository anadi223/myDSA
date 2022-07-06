package com.demo.LightWeightBaby.BinarySearchTree;


//https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1#
public class KthSmallestElement {
    static int i,ans; // i --> to check the count,, ye increment tabhi hoga jab inorder traversal me LNR me se N wale step pe rhega..and "ans" is to store the answer
    public static void main(String[] args) {
        
    }


	public static int kthSmallest(Node root, int k) {
          ans = -1;
        i = 0;
        inOrder(root,k);
        return ans;
    }
        static void inOrder(Node root, int k){
        if(root == null){
            return;
        }
        //!Left
       inOrder(root.left,k); //left call 
       //!Node
        i++;  // left call ke baad N wala step and N wale step me hi counter increase hoga
        if(i == k){ // check karo ki k ke barabar hai count if yes ans me store krwa lo
            ans= root.data;
        }
        //!Right
         inOrder(root.right,k); // right ki call
    }
}
