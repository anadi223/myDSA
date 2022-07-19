package com.demo.StriverSDESheet.LinkedList.Day5;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
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

    //TC O(2N)
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
    //TC O(N)
    static Node removeNthNodeApproach2(Node head, int n){
        Node start = new Node();
        start.next = head;
        //Lets find the mid
        Node slow = start; // initially slow aur fast head se phle hoga mtlb slow ka next head aur fast ka next head ko point kar rha hoga
        Node fast = start;

        //fast ko n tak bdhao
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        while(fast.next !=null){ // jab fast n tk aa jaaye tab fast aur slow ko ek ek bdhao jab tak fast ka next null ko na point kare
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; // jab loop se bahar aaoge toh tm us node se phle hoge jisko delete krna rhega toh simple eg..1 2 3  2 ko delete krna toh 1 ka next point karwa do 1 ke next ke next pe
        return start.next; // start initially null hai is liye start.next return krwa rhe
    }

 
}


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
    Node(){}
}