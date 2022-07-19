package com.demo.StriverSDESheet.LinkedList.Day5;


//Add two numbers already done in LL 
//https://leetcode.com/problems/add-two-numbers/
public class Question5 {
    public static void main(String[] args) {
        
    }

    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node forward = null;

        while(curr != null){
            forward  =curr.next;
            curr.next = prev;
            prev = curr;
            curr =forward;
        }
        return prev;
    }

    static Node addTwoNumbers(Node first, Node second){
        first = reverse(first);
        second = reverse(second);

        Node ansHead = null;
        ansHead = add(first,second);
        return ansHead;
    }
    static Node add(Node first, Node second){
        int carry=0;
        Node ansHead = null;
        while(first!= null || second != null || carry!=0){
            int val1 =0;
            if(first!=null){
                val1 = first.data;
            }

            int val2 = 0;
            if(second !=null){
                val2 = second.data;
            }
            int sum = carry+val1+val2;
            int digit = sum%10;
            carry = sum/10;

            Node digitNode = new Node(digit);
            digitNode.next = ansHead;
            ansHead = digitNode;

            if(first!=null){
                first = first.next;
            }

            if(second!= null){
                second = second.next;
            }
        }
        return ansHead;
    }
}
