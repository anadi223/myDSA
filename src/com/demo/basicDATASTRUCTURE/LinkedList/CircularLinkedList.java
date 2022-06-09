package com.demo.basicDATASTRUCTURE.LinkedList;

public class CircularLinkedList {
    public static void main(String[] args) {
        Node head =null;

        head = insertHead(head, 11);
        printList(head);

        head = insertHead(head, 13);
        head = insertHead(head, 14);
        printList(head);
        head = insertHeadEffecient(head, 15);
        System.out.println("-----Insert effeciently at head called");
        printList(head);
        insertAtEnd(head, 16);
        System.out.println("-----Insert at end called");
        printList(head);
        head=insertAtEndEffeciently(head, 19);
        System.out.println("-----Insert effeciently at end called");
        printList(head);
       head= deleteNode(head);
        // System.out.println("-----Delete head called");
        // printList(head);
        // head=deleteHeadEffeciently(head);
        // System.out.println("-----Delete efficient head called");
        // printList(head);
       head= deleteKthNode(head, 3);
        System.out.println("--Kth Node delete");
        printList(head);
    }

    //!Insert at Head O(n) time
    static Node insertHead(Node head, int data){
        Node temp = new Node(data);
        if(head==null){ // agar empty hai toh
            temp.next = temp;
            return temp;
        }
        else{
            Node curr = head; //rest of the case
            while(curr.next !=head){ //while loop chalaya hai to find the head position bhaiya circular linked list me head khin bhi ho skta hai 
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
            return temp;
        }
    }
    //*Insert at head in O(1) time */
    static Node insertHeadEffecient(Node head, int data){
        Node temp = new Node(data);
        if(head == null){
            temp.next = temp;
            return temp;
        }

        temp.next = head.next; // temp ko head ke aage store krwa do
        head.next = temp;
        int swap = head.data; // temp aur head ki values change krwa do 
        head.data = temp.data;
        temp.data = swap;
        return head;
    }

    //?Insert at end Time Complexity O(n)//
    static Node insertAtEnd(Node head, int data){
        Node temp = new Node(data);
        if(head ==null){
            temp.next = temp;
            return temp;
        }
        Node curr = head;
        while(curr.next !=head){
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = head;
        return head;

    }
    //?Insert at end effeciently O(1)//
    static Node insertAtEndEffeciently(Node head, int data){
        Node temp = new Node(data);
        if(head==null){
            temp.next = temp;
            return temp;        
        }

        temp.next = head.next;
        head.next =temp;
        int swap = temp.data;
        temp.data = head.data;
        head.data = swap;
        return temp; // TEMP WILL BECOME THE NEW HEAD
    }

    //*Delete the head node O(N)*/
    static Node deleteNode(Node head){
        if(head == null) return null;
        if(head.next ==head) return null;

        Node curr = head;
        while(curr.next != head){
            curr = curr.next;
        }
        curr.next = head.next;
        return curr.next;

    }
    //*Delete head node effeiciently O(1)*/
    static Node deleteHeadEffeciently(Node head){
        if(head ==null) return null;
        if(head.next == head) return null;

        head.data = head.next.data; //copy krdo head ke aage ka data head me
        head.next = head.next.next; // head ke agle ko uske agle ke agle pe point kr do
        return head;
    }

    //!Delete at Kth Position
    static Node deleteKthNode(Node head, int position){
        if(head==null) return head;
        if(position==1) return deleteNode(head);

        Node curr = head;
        int count=1;
        while(count<position-1){
            curr = curr.next;
            count++;
        }
        curr.next =  curr.next.next;
        return head;
    }




    //!Print list
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