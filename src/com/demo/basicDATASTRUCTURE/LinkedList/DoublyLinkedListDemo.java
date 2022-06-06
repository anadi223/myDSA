package com.demo.basicDATASTRUCTURE.LinkedList;


public class DoublyLinkedListDemo {
    public static void main(String[] args) {


        

        
        Node head = new Node(20);
        printList(head);
        int l = getLinkedListLength(head);
        System.out.println(l);

        // head = insertAtHead(head, 13);
        // System.out.println("-------------Insert at head called------");
        // printList(head);
    DoublyLinkedListDemo dll = new DoublyLinkedListDemo();
    dll.push(34, head);
    printList(head);
    }

    public void push(int new_data,Node head)
{
    /* 1. allocate node
    * 2. put in the data */
    Node new_Node = new Node(new_data);
 
    /* 3. Make next of new node as head and previous as NULL */
    new_Node.next = head;
    new_Node.prev = null;
 
    /* 4. change prev of head node to new node */
    if (head != null)
        head.prev = new_Node;
 
    /* 5. move the head to point to the new node */
    head = new_Node;
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