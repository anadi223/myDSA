package com.demo.LightWeightBaby.BinaryTree.TreeTraversals;


//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1/
import java.util.ArrayList;

public class LeftView {
    public static void main(String[] args) {
        
    }

    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans  =  new ArrayList<>();
      solve(root,ans,0);
      return ans;
    }
    static void solve(Node root, ArrayList<Integer> ans ,  int level){
        if(root == null){ // base case
            return;
        }
        
        if(level == ans.size()){ // agar tmhra level array ke size ke barabar ho jaaye mtlb you are at the next level
            ans.add(root.data);
        }
        solve(root.left,ans,level+1); // left call
        solve(root.right,ans,level+1); // right call
        
    }
}
