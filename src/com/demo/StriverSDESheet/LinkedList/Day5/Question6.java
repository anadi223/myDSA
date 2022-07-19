package com.demo.StriverSDESheet.LinkedList.Day5;

public class Question6 {
    public static void main(String[] args) {
        
    }
    //TC O(1) SC O(1)
    //https://leetcode.com/problems/delete-node-in-a-linked-list/
    //The approach is to copy the next node’s value in the deleted node. Then, link node to next of next node. This does not delete that node but indirectly it removes that node from the linked list.
    static void deleteNode(Node t) {
        if(t==null)
        return;
        t.data = t.next.data;
        t.next = t.next.next;
        return;
    }
    
}
