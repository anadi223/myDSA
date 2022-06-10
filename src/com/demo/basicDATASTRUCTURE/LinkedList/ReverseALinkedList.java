package com.demo.basicDATASTRUCTURE.LinkedList;


//https://www.codingninjas.com/codestudio/problems/reverse-the-singly-linked-list_799897?source=youtube&campaign=Lovebabbarcodestudio_24thJan&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio_24thJan&leftPanelTab=1
public class ReverseALinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node n1 = new Node(11);
        Node n2 = new Node(12);
        head.next = n1;
        head.next.next =n2;
        printList(head);
        // head=iterativeReverse(head);
        // System.out.println("-------Iterative Reversed--------");
        // printList(head);
       head= reverseRecursiveCall(head);
        System.out.println("-------Recursive Reversed--------");
        printList(head);

    }
    public static void printList(Node head){
        Node temp =head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static Node iterativeReverse(Node head){
        if(head == null) return null;
        if(head.next ==null) return head;

        Node prev = null;
        Node curr = head;
        Node forward;

        while(curr !=null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }


    public static Node reverseRecursiveCall(Node head){
       if(head==null || head.next == null){
           return head;
       }
       
       Node chotaHead = reverseRecursiveCall(head.next);
       head.next.next = head;
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
