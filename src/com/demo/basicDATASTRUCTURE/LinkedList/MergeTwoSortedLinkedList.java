package com.demo.basicDATASTRUCTURE.LinkedList;



//https://www.codingninjas.com/codestudio/problems/merge-two-sorted-linked-lists_800332
public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(5);


       Node head= mergeTwoSorted(head1, head2);
        System.out.println("Merged");
        printList(head);
        // System.out.println("-------------------------");
        // printList(head2);
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp =temp.next;
        }
    }

    static Node mergeTwoSorted(Node h1 , Node h2){
        if(h1 == null)
        return h2;

        if(h2==null)
        return h1;

        Node head  =null;
        Node tail = null;

        if(h1.data<=h2.data){
            head =tail = h1;
            h1 = h1.next;
        }else{
            head = tail = h2;
            h2 = h2.next;
        }

        while(h1!=null && h2!=null){
            if(h1.data<=h2.data){
                tail.next = h1;
                tail =h1;
                h1 = h1.next;
            }
            else{
                tail.next =h2;
                tail =h2;
                h2= h2.next;
            }
        }
        if(h1 == null){
            tail.next = h2;
        }else{
            tail.next = h1;
        }
        return head;
    }

}
