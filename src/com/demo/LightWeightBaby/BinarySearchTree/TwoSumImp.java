package com.demo.LightWeightBaby.BinarySearchTree;

import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1/#
public class TwoSumImp {
    public static void main(String[] args) {
        
    }

    boolean twoSumInBST(Node root, int target){
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root, ans); //inorder traversal ka result sorted aata hai

        //Now we have the array in sorted order
        //Now apply two pointer approach on the array

        int i=0, j =ans.size()-1;
        while(i<j){
            int sum = ans.get(i) + ans.get(j); // ek sum variable le lo
            if(sum == target){ 
                return true;
            }
            else if(sum > target){ //agar current sum hi bda hai mtlb j-- karo why bhia j is the last element mtlb usse phle wale sab chote honge aur hmko chota hi chahiye hoga
                j--;
            }else{
                i++; //opposite of above case
            }
        }
        return false;
    }

    void inOrder(Node root, ArrayList<Integer> ans){ // storing the result of inorder traversal 
        if(root == null){
            return;
        }

        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);

    }

}
