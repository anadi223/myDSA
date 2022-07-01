package com.demo.LightWeightBaby.BinaryTree;

import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/k-sum-paths/1/#
public class KSumPaths {
    static int count;
    public static void main(String[] args) {
        
    }
    static int findKSumPath(Node root, int k){
        ArrayList<Integer> path  = new ArrayList<>();
        count =0;
        solve(root,k,path);
        return count;
    }
     static void solve(Node root, int k, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.data); // root ka data add karo

        solve(root.left, k, path); //left ki call
        solve(root.right, k, path); // right ki call

        int sum=0;
        int size = path.size(); // jab recursive call pe aaoge aur last node pe rhoge toh us time me path wala array me values hongi
        for(int i=size-1;i>=0;i--){
            sum+=path.get(i);
            if(sum == k){
                count++;
            }
        }
        path.remove(path.size()-1); // recursive call se jab return hoge toh path wali list ki original list maintain krne ke liye


    }

    
}
