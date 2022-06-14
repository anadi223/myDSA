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
        // O(m+n) time
    static Node mergeTwoSorted(Node h1 , Node h2){
        if(h1 == null)
        return h2; //if h1 is null then no need to merge

        if(h2==null)
        return h1; // if h2 is null no need to merge

        Node head  =null; //head and tail pointer 
        Node tail = null;

        if(h1.data<=h2.data){ // head aur tail pointer ko us h1 ya h2 ko assign kro jo ki chota hai 
            head =tail = h1;
            h1 = h1.next; // assign krne ke baad h1 ko aage bdha do
        }else{
            head = tail = h2;
            h2 = h2.next;
        }

        while(h1!=null && h2!=null){ 
            if(h1.data<=h2.data){ //check karo h1 aur h2 ka data since tail pointer already kisi ek head ko point kr rha toh next pointer kaun sa hoga uske liye aur jo bhi chota hai usko assign kr do tail ke next ko aur tail ko aage bdha do aur head ko aage bdha do
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
        if(h1 == null){ // suppose koi ek list khtm hogyi toh tail ke agle ke baaki bchi hui list pe point kr do isse
            tail.next = h2;
        }else{
            tail.next = h1;
        }
        return head;
    }

}
