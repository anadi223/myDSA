package com.demo.LightWeightBaby.BinaryTree.TreeTraversals;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1/
//SIMILAR TO LEFT VIEW
public class RightView {
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

        solve(root.right,ans,level+1); // right call phle whyyy ----- right view dekh rhe na hm toh right ki call phklee
        solve(root.left,ans,level+1); // left call
        
        
    }
}
