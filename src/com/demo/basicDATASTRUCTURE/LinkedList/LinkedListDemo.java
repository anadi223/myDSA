package com.demo.basicDATASTRUCTURE.LinkedList;

import java.util.HashMap;

public class LinkedListDemo {
    public static Node head;
    public static void main(String[] args) { 
        
         head = new Node(10);

         Node tail = head;

         head = insertAtHead(head, 444444);
         head = insertAtHead(head, 5555);

          insertAtEnd(tail, 23);
         insertAtEnd(tail, 43);
       // tail.next = head.next;
         //printList(head);
         Node begginning  = getStartingNode(head);
         if(begginning ==null){
            System.out.println("NOPE");
         }else{
         System.out.println(begginning.data);
         }
        //  System.out.println("---------------Printing for tail ------------");
        //  printListForTail(tail);

        //  tail=insertAtEnd2(tail, 222);
        // tail= insertAtEnd2(tail, 1111);
        //  System.out.println("---------------Printing for tail 2 ------------");
        //  printListForTail(tail);



    //     insertAtHeadMethod2(head,556);
    //     insertAtHeadMethod2(head,545454);
    //  System.out.println("---------------Printing for head ------------");
    //    printList(head);

    //    int pos = 1;
    //    deleteNode(head, pos);
    //    System.out.println("---------------After deleting print in main method ----------------");
    //    printList(head);


    
    // int x=11;
    // int position=0;
    // LinkedListDemo ld = new LinkedListDemo();
    // ld.insertAtAnyPosition(x, head, position);
    // System.out.println("--------------Insert at any position-----------------");
    // printList(head);

    }

    static Node floydCycleDetection(Node head){
        if(head==null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        while(slow !=null && fast != null){
            fast = fast.next; // fast do baar aage bdh rha
            if(fast !=null){
                fast= fast.next;
            }
            slow = slow.next;
            if(fast == slow){ // wo condition jahan pe fast slow ko pakad lega
                return slow; //IS NODE PE HAI WO INTERSECTIONN
            }
        }
        return null;
    }

    static Node getStartingNode(Node head){
        if(head == null) return null;
        Node pointOfIntersection = floydCycleDetection(head);
        if(pointOfIntersection == null) return null;
        Node slow = head;
        while(slow !=pointOfIntersection && pointOfIntersection !=null){
            slow = slow.next;
            pointOfIntersection = pointOfIntersection.next;
        }
        return slow;
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


    //?Another way to insert AT END::::::
    static Node insertAtEnd2(Node tail , int x){
        Node temp = new Node(x);
        tail.next = temp;
        return temp;
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


    static void deleteHead(Node head){
        head = head.next;

    }

    //?Delete a Node either from start end or middle
    static void deleteNode(Node head, int position){

        //Delete at first position
        if(position==1){
            deleteHead(head);
            System.out.println("INSIDE METHOD CALL PRINTING");
            printList(head);
            return;
            // head = head.next;
            

            // return;
        }


        //Delete at mid or last position

        Node curr = head;
        Node prev = null;
        int count=1;
        while(count<position-1){
            prev = curr;
            curr = curr.next;
            count++;
        }
        prev.next = curr.next;
        curr.next = null;


    }



    
}
 
class Node{
int data;
Node next;


//*constructor */
public Node(int x){
    this.data =x;
    this.next = null;
}
}
