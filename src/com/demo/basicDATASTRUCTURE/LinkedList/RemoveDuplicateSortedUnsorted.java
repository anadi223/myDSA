package com.demo.basicDATASTRUCTURE.LinkedList;

import java.util.HashMap;

//https://www.codingninjas.com/codestudio/problems/unique-sorted-list_2420283
public class RemoveDuplicateSortedUnsorted {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(5);
        printList(head);
       head= unsortedList(head);
       System.out.println("---Unsorted---");
        printList(head);
        // head=sortedList(head);
        // System.out.println("--------Sorted delete---");
        // printList(head);
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    static Node sortedList(Node head){
        if(head == null)
        return null;

        Node curr = head;
        while(curr !=null){
            if(curr.next !=null && curr.data == curr.next.data){
            Node nextOfNext = curr.next.next;
            curr.next = nextOfNext;
        }
        else{
            curr =curr.next;
        }

        }

        return head;
    }
    //Unsorted waala nhi kiyua abi
    //! Unsorted ka ek approach --- sort kr do phle phir upr wali algo lga do hogya kaam
}
