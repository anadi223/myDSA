package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


//https://www.codingninjas.com/codestudio/problems/next-smaller-element_1112581?topList=love-babbar-dsa-sheet-problems&leftPanelTab=1
public class NextSmallerElement {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(2,1,4,3));
        ArrayList<Integer> ans  = findNextSmall(arr, arr.size());
        for(int x: ans){
            System.out.print(x+ " ");
        }
    }
    
    static ArrayList<Integer> findNextSmall(ArrayList<Integer> arr ,  int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1);

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            int curr = arr.get(i);
            while(s.peek() >=curr){
                s.pop();
            }
            ans.add(s.peek());
            s.push(curr);
        }
        Collections.reverse(ans);
        return ans;
    }
}
