package com.demo.basicDATASTRUCTURE.LinkedList;

//https://www.codingninjas.com/codestudio/problems/middle-of-linked-list_973250?source=youtube&campaign=Lovebabbarcodestudio_24thJan&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio_24thJan
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        head.next = n1;
        head.next.next =n2;
        head.next.next.next = n3;

        Node ans = findMidByLength(head);
        System.out.println("Printing mid by length approach "+ ans.data);
    }
    static int findLength(Node head){ //length ka alag function is liye bnaya hai ki head ka pointer update kr rhe baar baar toh agar ek saath hi kr lenge toh node temp change hoke null ho jata kyuki head null ho gya hoga length nikalte time loop krte time
        int length=0;
        while(head !=null){
            head = head.next;
            length++;
        }
        return length;
    }

    //!Approach 1 by finding the length of a linked list O(N)
    static Node findMidByLength(Node head){
        int length =findLength(head);
        int ans = length/2;
        Node temp = head;
        int count=0;
        while(count<ans){
            temp =temp.next;
            count++;
        }
        return temp;
    }

    //?O(n)
    static Node optimizedFind(Node head){
        if(head == null || head.next == null)return head;
        if(head.next.next == null) return head.next;

        Node slow = head;
        Node fast = head.next;
        
        while(fast !=null){
            fast = fast.next;
            if(fast !=null){
                fast= fast.next;
            }
            slow = slow.next;
        }
        return slow;
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