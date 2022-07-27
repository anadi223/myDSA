package com.demo.StriverSDESheet.LinkedList.Day6;

import java.util.ArrayList;

public class Question4 {
    public static void main(String[] args) {
        
    }
    // TC O(N) SC O(n)
    static boolean isPalindromeApproach1(Node head){

        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            arr.add(temp.data);
            temp = temp.next;
        }
        return checkPalindromeInArray(arr);
    }

    static boolean checkPalindromeInArray(ArrayList<Integer> arr){
        if(arr.size() ==0){
            return true;
        }

        int l=0;
        int r = arr.size()-1;

        while(l<=r){
            if(arr.get(l) != arr.get(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
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
