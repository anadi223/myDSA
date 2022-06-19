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
    
    //!O(N) TIME AND SPACE
    static ArrayList<Integer> findNextSmall(ArrayList<Integer> arr ,  int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1); //right se start krna toh first element to -1 hi milega na

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            int curr = arr.get(i);
            while(s.peek() >=curr){ // while loop tab tak chalao jab tak jo current element hai wo stack element se chota na mil jaaye
                s.pop();
            }
            ans.add(s.peek()); // while se bahar aa gye that means hme chota element mil gya
            s.push(curr); // stack me curr element daal do agle element bhi toh process krne hai
        }
        Collections.reverse(ans); // hm right se element dekh rhe aur ans me 0 index se daal rhe is liye reverse
        return ans;
    }
}
