package com.demo.basicDATASTRUCTURE.LinkedList;

import java.util.ArrayList;

//https://leetcode.com/problems/palindrome-linked-list/
public class CheckPalindrome {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        //head.next.next = new Node(3);

       // boolean ans = checkPalindromeApproach1(head);
        boolean ans = isPalindromeApproach2(head);
        System.out.println(ans);
    }

    //TC AND SC = O(n)
    public static boolean checkPalindromeApproach1(Node head){
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp!=null){
            arr.add(temp.data);
            temp = temp.next;
        }
        return checkPalindromeByArray(arr);
    }

    static boolean checkPalindromeByArray(ArrayList<Integer> arr){
        int l = 0;
        int r = arr.size()-1;
        while(l<=r){
            if(arr.get(l) != arr.get(r)){
                return false;
            }
            l++;
            r--;
        }

        return true; // bhaiya jab loop khtm hogya aur condition match nhi hua toh mtlb hai ki palindrome hai
    }
             

    //! APPROACH 2 -- Get the middle element, reverse the list after mid,, compare the two parts the non reversed and reversed,, reverse back as we dont want list to be manipulated


    static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    static Node reverseList(Node head){
        Node prev = null;
        Node curr = head;
        Node forward = null;
        while(curr!=null){
            forward = curr.next;
            curr.next = prev;
            prev= curr;
            curr=forward;
        }
        return prev;
    }

    static boolean isPalindromeApproach2(Node head){
        if(head.next == null){
            return true;
        }
        Node middle = getMid(head);
        Node temp = middle.next;
        middle.next = reverseList(temp);

        Node h1 = head;
        Node h2 = middle.next;

        while(h2 !=null && h1!=null){

            if(h2.data != h1.data){
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        temp = middle.next;
        middle.next = reverseList(temp);

        return true;
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
