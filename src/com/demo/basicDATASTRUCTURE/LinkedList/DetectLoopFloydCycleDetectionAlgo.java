package com.demo.basicDATASTRUCTURE.LinkedList;

import java.util.HashMap;

//https://www.codingninjas.com/codestudio/problems/interview-shuriken-42-detect-and-remove-loop_241049
//! Question can be of different type:  1. Find loop, 2. Remove Loop , 3. Find the head from where loop starts 
public class DetectLoopFloydCycleDetectionAlgo {
    public static void main(String[] args) {
        
    }

    //Approach 1: Using map O(n) TC AND SC 
    //https://leetcode.com/problems/linked-list-cycle/
    static boolean detectLoop(Node head){
        if(head ==null)return true;
    
        HashMap<Node,Boolean> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            //cycle hai guru 
            if(map.containsKey(temp)){
                return true;
            }
            map.put(temp,true);
            temp = temp.next;
        }
        return false;
    }

    //!!Detect Loop FLOYD'S CYCLE DETECTION ALGO
    static boolean floydCycleDetection(Node head){
        if(head==null) return false;

        Node slow = head;
        Node fast = head;
        while(slow !=null && fast != null){
            fast = fast.next;
            if(fast !=null){
                fast= fast.next;
            }
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
