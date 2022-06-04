package com.demo.basicDATASTRUCTURE.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        
        Node head = new Node(10);
        Node temp1 = new Node(20);
        head.next = temp1;
        temp1.next = null;

        System.out.println(head.data);
        System.out.println(temp1.data);
        
    }
    
}

class Node{
int data;
Node next;

public Node(int x){
    data =x;
    next = null;
}
}
