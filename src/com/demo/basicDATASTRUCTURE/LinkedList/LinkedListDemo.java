package com.demo.basicDATASTRUCTURE.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        
        Node head = new Node(10);

        System.out.println(head.data);



        head = insertAtHead(head, 444444);
        head = insertAtHead(head, 5555);

        printList(head);
    }

    //printing a Linked List 

    static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data+ " ");
            curr = curr.next;
        }
    }

    //insert data at start
    static Node insertAtHead(Node head, int x){
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }
    
}
 
class Node{
int data;
Node next;


//*constructor */
public Node(int x){
    data =x;
    next = null;
}
}
