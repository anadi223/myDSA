package com.demo.basicDATASTRUCTURE.LinkedList;

import java.util.HashMap;

//https://www.codingninjas.com/codestudio/problems/interview-shuriken-42-detect-and-remove-loop_241049
//! Question can be of different type:  1. Find loop, 2. Remove Loop , 3. Find the head from where loop starts 
public class DetectLoopFloydCycleDetectionAlgo {
    public static void main(String[] args) {
        //*Tried the code in singly linked list file --> LinkedListDemo.java
    }

    //Approach 1: Using map O(n) TC AND SC 
    //https://leetcode.com/problems/linked-list-cycle/
    static boolean detectLoop(Node head){
        if(head ==null)return true;
    
        HashMap<Node,Boolean> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            //cycle hai guru 
            if(map.containsKey(temp)){ //agar map me vo value phle se hai that means it is visited that means cycle present
                return true;
            }
            map.put(temp,true);
            temp = temp.next;
        }
        return false;
    }

    //!!Detect Loop FLOYD'S CYCLE DETECTION ALGO TC -- O(n) SC O(1)
    //https://leetcode.com/problems/linked-list-cycle/
    static Node floydCycleDetection(Node head){
        if(head==null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        while(slow !=null && fast != null){
            fast = fast.next; // fast do baar aage bdh rha
            if(fast !=null){
                fast= fast.next;
            }
            slow = slow.next;
            if(fast == slow){ // wo condition jahan pe fast slow ko pakad lega
                return slow; //IS NODE PE HAI WO INTERSECTIONN
            }
        }
        return null;
    }

    //https://leetcode.com/problems/linked-list-cycle-ii/
    static Node getStartingNode(Node head){
        if(head == null) return null;
        Node pointOfIntersection = floydCycleDetection(head);
        if(pointOfIntersection == null){ //extra check ki bhaiya agar koi loop na ho toh intersection to null hi aayega na toh bahar aa jao loop se
            return null;
        }
        Node slow = head;
        while(slow !=pointOfIntersection){
            slow = slow.next;
            pointOfIntersection = pointOfIntersection.next;
        }
        return slow;
    }
    //https://www.codingninjas.com/codestudio/problems/interview-shuriken-42-detect-and-remove-loop_241049
    static Node removeLoop(Node head){
        if(head == null) return null;
        Node startOfLoop = getStartingNode(head);
        if(startOfLoop ==null) return head;

        Node temp = startOfLoop;
        while(temp.next !=startOfLoop){
            temp = temp.next;
        }
        temp.next =null;
        return head;
    }

}
