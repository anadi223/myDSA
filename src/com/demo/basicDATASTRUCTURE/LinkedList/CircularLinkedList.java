package com.demo.basicDATASTRUCTURE.LinkedList;

public class CircularLinkedList {
    public static void main(String[] args) {
        Node head =null;

        head = insertHead(head, 11);
        printList(head);

        head = insertHead(head, 13);
        head = insertHead(head, 14);
        printList(head);

    }
    

    static Node insertHead(Node head, int data){
        Node temp = new Node(data);
        if(head==null){ // agar empty hai toh
            temp.next = temp;
            return temp;
        }
        else{
            Node curr = head; //rest of the case
            while(curr.next !=head){
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
            return temp;
        }


        

    }

    static void printList(Node head){

        if(head == null) return;
        System.out.println(head.data);

        for(Node r = head.next; r!=head;r=r.next){
            System.out.println(r.data);
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