package com.demo.LightWeightBaby.BinaryTree;


//https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1/
public class MaximumSumOfNonAdjacentNodes {
    public static void main(String[] args) {
        
    }
    static int getMaxSum(Node root){
        Pair ans = solve(root);
        return Math.max(ans.first, ans.second); // do ans aayenge hmare paas ek include krkr current node ko ek na krke donon me se jo max hoga wo ans hai tmhra
    }
    static Pair solve(Node root){
        if(root == null){
            Pair pair = new Pair(0, 0);
            return pair;
        }

        Pair left = solve(root.left); // left call
        Pair right = solve(root.right); // right call

        Pair res = new Pair(0, 0); // result
        res.first = root.data + left.second + right.second; // ye wo case hai jab current node ko include kar rhe-=- jab current node include hogi in that case bhaiya reason dekhna notes me 
        res.second = Math.max(left.first, left.second) + Math.max(right.first, right.second); // jab current node ko include nahi kar rhe 

        return res;

    }
}


class Pair{ //helper class
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}