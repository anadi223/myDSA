package com.demo.StriverSDESheet.LinkedList.Day5;

//https://leetcode.com/problems/reverse-linked-list/
//Reverse a Linked List Already Explained in Linked List Section
public class Question1 {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
       // Node ans = reverseLinkedList(head);
       Node ans  = recursiveReverse(head);
        while(ans!=null){
            System.out.print(ans.data+" ");
            ans=ans.next;
        }
    }
    static Node reverseLinkedList(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node forward = null;
        while(curr !=null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    static Node recursiveReverse(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node chotaHead = recursiveReverse(head.next);

        head.next.next = head;;
       head.next = null;
       return chotaHead;
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
