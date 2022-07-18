package com.demo.StriverSDESheet.LinkedList.Day5;

public class Question4 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        int n =1;
        Node ans = removeNthNodeApproach1(head, n);
        while(ans != null){
            System.out.print(ans.data+" ");
            ans =ans.next;
        }

    } 
    static Node removeNthNodeApproach1(Node head, int n){
        if(head == null || head.next == null){
            return null;
        }

        int length = getLinkedListLength(head);
        int travesalLength  = length-n;
        Node temp = head;
        for(int i=1;i!=travesalLength;i++){
            temp =temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    static int getLinkedListLength(Node head){
        if(head == null){
            return 0;
        }
        int count=0;
        Node temp = head;
        while(temp != null){
            count++;
            temp =temp.next;
        }
        return count;
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