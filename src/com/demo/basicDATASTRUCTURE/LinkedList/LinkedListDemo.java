package com.demo.basicDATASTRUCTURE.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) { 
        
        Node head = new Node(10);

        Node tail = head;

         insertAtEnd(tail, 23);
        insertAtEnd(tail, 43);

        System.out.println("---------------Printing for tail ------------");
        printListForTail(tail);

        head = insertAtHead(head, 444444);
        head = insertAtHead(head, 5555);

    //    insertAtHeadMethod2(head,556);
    //    insertAtHeadMethod2(head,545454);
    System.out.println("---------------Printing for head ------------");
      printList(head);


      int position =3;
      insertAtPosition(head, position, 999);

      System.out.println("--------Printing for insert at Middle");
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


    //Printing for tail
    static void printListForTail(Node tail){
        Node curr = tail;
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

    static void insertAtHeadMethod2(Node head, int x){
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        return;
    }

    //*Insert At End */
    static void insertAtEnd(Node tail , int x){
        Node temp = new Node(x);
        while(tail.next !=null){
            tail = tail.next;
        }
        tail.next = temp;
        // tail = tail.next;
        return;
    }

    //!Insert at a Given Position
    static void insertAtPosition(Node head, int position, int x){
        Node temp = head;
        int count =1;
        while(count< position-1){
            temp = temp.next;
            count++;
        }

        //creating a new node to insert
        Node nodeToInsert = new Node(x);
        nodeToInsert.next = temp.next;
        temp.next = nodeToInsert;
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
