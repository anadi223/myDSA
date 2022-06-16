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
        Node cloneTail =null;

        Node temp = head;
        while(temp!=null){
            Node newNode = new Node(temp.data);
            if(cloneHead == null){
                cloneHead = newNode;
                cloneTail = newNode;
            }
            else{
                cloneTail.next = newNode;
                cloneTail = newNode;
                System.out.println(cloneTail.data + ":::::::::::::::::::::::::");
            }
            temp = temp.next;
        }
        return cloneTail;
    }

    static void insertAtTail(Node head, Node tail , int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
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