package com.demo.StriverSDESheet.LinkedList.Day6;

public class Question3 {
    public static void main(String[] args) {
        
    }

    static Node reverseKGroups(Node head, int k){
        if(head == null || head.next == null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node forward = null;
        int count =0;
        while(curr != null && count<k){
            forward = curr.next;
            curr.next = prev;
            prev =curr;
            curr= forward;
            count++;
        }

        if(forward != null){
            head.next = reverseKGroups(forward, k);
        }
        return prev;
    }
}
