package com.demo.basicDATASTRUCTURE.LinkedList;

//https://www.codingninjas.com/codestudio/problems/circularly-linked_1070232
public class CircularLinkedListOrNot {
    public static void main(String[] args) {
        
    }

    static boolean isCircular(Node head){
        if(head == null || head.next == null) return false;
        if(head.next == head) return true;

        Node temp = head.next;

        while(temp !=null && temp !=head){
            temp = temp.next;
        }
        if(temp == head){
            return true;
        }
        return false;
    }

}
