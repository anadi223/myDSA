package com.demo.basicDATASTRUCTURE.LinkedList;

//https://leetcode.com/problems/add-two-numbers/submissions/
public class Add2NumbersFromLinkedList {
    public static void main(String[] args) {
        Node first = new Node(4);
        first.next = new Node(5);
        Node second = new Node(3);
        second.next = new Node(4);
        second.next.next = new Node(5);
        Node ans = addTwoNumbers(first, second);
        printList(ans);
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp =temp.next;
        }
    }
    static Node reverse(Node head){ // To reverse a list
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

    static Node addTwoNumbers(Node first, Node second){ // main function to add two numbers

        // Step1: Reverse both the list since sum peeche se add karte na
        first = reverse(first);
        second = reverse(second);

        Node ans = null;
        //ek ans node bnao jisko return karna hai 
        ans = add(first,second); //to add two list main logic
        ans  = reverse(ans);

        return ans;
    }

    static Node add(Node first, Node second){

        //steps:: sum nikalo digit nikalo digit ki node banao kyuki digit hi toh aayegi,, carry nikalo aage bdho

        int carry =0;
        Node ansHead= null; //answer list jo merge hogi

        while(first!=null || second !=null || carry!=0){  // tab tak iterate karo jab tak ek na ek condition hai,, first!=null kya pta ek list 3,4 hai ek 3,4,5 hai toh jab 5 pe aayega tab tak toh list 1 khtm ho chuki hogi na mtlb null point kar rhi hogi.. and one more possible case carry ka if list is 5,5 and 5,5 toh answer kya hai 110 toh ek extra node create hogi carry ki 

            int val1 =0;
            if(first!=null){ // ye logic wo case handle krega jab suppose first iterate krte krte null hogya and we need to add second to first,, toh ek helper val1 ko 0 le lo and agar first null na ho tab hi value ko update karo with the data else val1 toh 0  hai toh if tum sum niakl rhe aur null bhi aaya hm sum me val1 add kar rhe which is zero so code nhi phtega for eg. 34 + 345 jab 5 pe aaoge toh list 1 toh null hai lekin val1 abhi bhi 0 hai us iteration ke liye toh code nhi phatega
                val1 = first.data;
            }

            int val2 =0;
            if(second!=null){ //similar to above
                val2 = second.data;
            }

            int sum = carry+val1+val2;  // find sum for 1 node
            int digit = sum%10; // find digit kaun si value node pe jayegi
            carry =sum/10; //carry niaklo

            Node digitNode = new Node(digit); // ek node bna rhe digit ke liye
            digitNode.next = ansHead; //*INSERT AT TAIL HERE */ ans ka agla anshead ko point kro mtlb insert at tail ho rha yahan
            ansHead = digitNode; // aur node update ho rha ansHead ka 

            if(first!=null){
                first = first.next; // first null ko na point kar de is liye if condition
            }
            if(second!=null){
                second =second.next; //similar to above
            }
        }
        return reverse(ansHead);    
    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next=null;
    }
}