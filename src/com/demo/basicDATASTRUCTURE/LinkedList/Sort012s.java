package com.demo.basicDATASTRUCTURE.LinkedList;

//https://www.codingninjas.com/codestudio/problems/sort-linked-list-of-0s-1s-2s_1071937
public class Sort012s {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(2);
        printList(head);
        sortO12Approach1(head);
        // head=sortWithoutModifyingList(head);
        System.out.println("\nSORT CALLED");
        printList(head);
    }


    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
    }
    //Approach 1 ye hai ki zero 1 and 2 ko count kr lo phir loop chla do ki linked list ke data ko modify kr do
    static Node sortO12Approach1(Node head){
        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;

        Node temp = head;
        while(temp!=null){
            if(temp.data ==0){
                zeroCount++;
            }
            else if(temp.data ==1){
                oneCount++;
            }
            else if(temp.data ==2){
                twoCount++;
            }
            temp =temp.next;
        }

        temp =head; // why because temp pehle wale loop ke hisab se null point kr rha hoga 
        while(temp !=null){
            if(zeroCount !=0){
                temp.data =0;
                zeroCount--;
            }
            else if(oneCount  !=0){
                temp.data = 1;
                oneCount--;
            }
            else if(twoCount !=0){
                temp.data =2;
                twoCount--;
            }
            temp =temp.next;
        }
        return head;
    }
    

    //METHOD NAHI CHL RHA REFERENCE WALA KHEL HAI ISME
    static Node sortWithoutModifyingList(Node head){
        Node zeroHead=new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node curr = head;
        while(curr !=head){
            int value =curr.data;
            if(value==0){
               zeroTail= insertAtTail(zeroTail,curr);
            }
            else if(value ==1){
                oneTail = insertAtTail(oneTail, curr);
            }
            else if(value ==2){
                twoTail =insertAtTail(twoTail, curr);
            }
            curr = curr.next;
        }

        System.out.println("PRINTING ZERO HEAD");
        printList(zeroHead);

        
        System.out.println("PRINTING One HEAD");
        printList(oneHead);
        
        System.out.println("PRINTING Two HEAD");
        printList(twoHead);
        //MERGE THE LIST
        if(oneHead.next !=null){
            zeroTail.next = oneHead.next;
        }
        else{
            zeroTail.next = twoHead.next;
        }

        oneTail.next = twoHead.next;
        twoTail.next = null;

        return head;
    }
    static Node insertAtTail(Node tail, Node curr){
        tail.next =curr;
        return curr;
    }

}
