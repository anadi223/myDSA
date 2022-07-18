package com.demo.StriverSDESheet.LinkedList.Day5;

//https://leetcode.com/problems/merge-two-sorted-lists/submissions/
public class Question3 {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        Node ans = sortedMerge(head1, head2);

        while(ans!= null){
            System.out.print(ans.data+" ");
            ans = ans.next;
        }
    }
    static Node sortedMerge(Node head1, Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        Node head = null, tail = null;

        if(head1.data<=head2.data){
            head = tail = head1;
            head1 = head1.next;
        }else{
            head =tail = head2;
            head2 = head2.next;
        }

        while(head1 != null && head2 !=null){
            if(head1.data <= head2.data){
                tail.next = head1;
                tail = head1;
                head1  = head1.next;
            }else{
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if(head1 == null){
            tail.next = head2;
        }else{
            tail.next = head1;
        }
        return head;
    }
}
