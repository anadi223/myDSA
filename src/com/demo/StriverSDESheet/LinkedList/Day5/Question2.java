package com.demo.StriverSDESheet.LinkedList.Day5;

//https://leetcode.com/problems/middle-of-the-linked-list/submissions/
//Middle of linked list slow and fast pointer approach explained in LL Section
public class Question2 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        Node ans = middleNode(head);
        System.out.println(ans.data);
        Node ansApproach1 = getMidAppraoch1(head);
        System.out.println(ansApproach1.data);
    }

    static Node middleNode(Node head){
        if(head == null||head.next == null){
            return null;
        }

        Node slow = head;
        Node fast = head.next;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast  = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    static int findLength(Node head){
        if(head == null){
            return 0;
        }
        int length=0;
        Node temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    static Node getMidAppraoch1(Node head){
        int length = findLength(head);
        int mid = length/2;
        Node temp = head;
        int count =0;
        while(count<mid){
            temp = temp.next;
            count++;
        }
        return temp;
    }

}
