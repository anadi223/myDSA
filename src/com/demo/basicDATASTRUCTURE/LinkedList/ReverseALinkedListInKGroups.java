package com.demo.basicDATASTRUCTURE.LinkedList;

//https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa2gzcjNTQW1PMG9jTEtGOE8zaUZGc3RNdmZNUXxBQ3Jtc0ttRk5GNlYzS2xSOE1yNXU3VFVuZHVHNm5KMjRBRE1NVEQwd1UzV2JTMzZtX280ZmtFM3hGTUx0dVdIWlpYZ1RnUXZ1X3djd3VDOXpSdUt3LTlnQnBHSXI4aDJqM0lqeUdQVmN2ZXYtU1hPWkx1Znd4QQ&q=https%3A%2F%2Fbit.ly%2F3r1rCIP&v=fi2vh0nQLi0
public class ReverseALinkedListInKGroups {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        printList(head);
        head=reverseUsingRecursion(head, 2);
        System.out.println("---_Reverse in 2-----");
        printList(head);
    }

    static void printList(Node head){
        Node temp = head;
        while(temp !=null){
            System.out.println(temp.data +" ");
            temp = temp.next;
        }
    }
    //Time O(n) SC O(n/k) = O(n)
    static Node reverseUsingRecursion(Node head, int key){
        if(head == null){
            return null;
        }

        Node prev = null;
        Node curr = head;
        Node forward=null;
        int count=0;
        while(curr != null && count<key){
            forward = curr.next;
            curr.next = prev;
            prev= curr;
            curr = forward;
            count++;
        }

        if(forward !=null){
            head.next = reverseUsingRecursion(forward, key);
        }
        return prev;
    }
}
