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

       int pos = 1;
       deleteNode(head, pos);
       System.out.println("---------------After deleting print in main method ----------------");
       printList(head);


    
    // int x=11;
    // int position=0;
    // LinkedListDemo ld = new LinkedListDemo();
    // ld.insertAtAnyPosition(x, head, position);
    // System.out.println("--------------Insert at any position-----------------");
    // printList(head);

    }
    static void deleteNode(Node head, int position){

        //Delete at first position
        if(position==1){
            head = head.next;
            System.out.println("INSIDE METHOD CALL PRINTING");
            printList(head);
            return;
        }


        //Delete at mid or last position

        Node curr = head;
        Node prev = null;
        int count=1;
        while(count<position){
            prev = curr;
            curr = curr.next;
            count++;
        }
        prev.next = curr.next;
        curr.next = null;


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


    //Not working method
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

    //?? Insert data anywhere with position
     void insertAtAnyPosition(int x,Node head, int position){
        Node toAdd = new Node(x);
        if(position==0){
            toAdd.next = head;
            head = toAdd;
            System.out.println("Printing head " + head.data);
            return;
        }

        Node prev = head;
        for(int i=0;i<position-1;i++){
            prev = prev.next;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;

    }

    

    //?Delete a Node either from start end or middle




    
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
