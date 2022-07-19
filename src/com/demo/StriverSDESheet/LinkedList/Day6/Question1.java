package com.demo.StriverSDESheet.LinkedList.Day6;

import java.util.HashSet;

//Find Intersection point of Y Linked List
//https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
public class Question1 {

    public static void main(String[] args) {
        
    }
        //TC O(m+n) SC O(n)  
        //aadha idea khud ka tha
    static Node getIntersectionNode(Node headA, Node headB){
        HashSet<Node> hs = new HashSet<>();
        while(headA!=null){
            hs.add(headA);
            headA = headA.next;
        }

        while(headB !=null){
            if(hs.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
