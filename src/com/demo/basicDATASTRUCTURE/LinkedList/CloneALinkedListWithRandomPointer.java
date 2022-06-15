package com.demo.basicDATASTRUCTURE.LinkedList;



public class CloneALinkedListWithRandomPointer {
    public static void main(String[] args) {
    
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node ans = clone(head);
        printList(ans);
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            temp =temp.next;
        }
    }
    static Node clone(Node head){
        Node cloneHead = null;
        Node temp = head;
        while(temp!=null){
            Node newNode = new Node(temp.data);
            cloneHead.next = newNode;
            //cloneHead = cloneHead.next;
            cloneHead =newNode;
            temp =temp.next;
        }
        return cloneHead;
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