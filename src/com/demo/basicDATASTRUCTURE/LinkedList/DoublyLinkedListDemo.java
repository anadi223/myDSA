package com.demo.basicDATASTRUCTURE.LinkedList;

import javax.swing.SortOrder;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {


        

        
        Node head = new Node(20);
        Node tail = head;
        printList(head);
        int l = getLinkedListLength(head);
        System.out.println(l);

        head = insertAtHead(head, 13);
        System.out.println("-------------Insert at head called------");
        printList(head);

        tail = insertAtTail(tail, 44);
        System.out.println("-----------------Insert at tail called---------------");
        printList(head);

    }



    //printing a list
    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    //getting the length of the linked list
    static int getLinkedListLength(Node head){
        int count=0;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    //Insert At head
    static Node insertAtHead(Node head, int data){
        Node temp  = new Node(data);
        temp.next = head;
        head.prev = temp;
        return temp;
    }
    
    static Node insertAtTail(Node tail, int data){
        Node temp = new Node(data);
        
        tail.next = temp;
        temp.prev = tail;
        return temp;
    }


    

}



class Node{
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}