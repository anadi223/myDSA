package com.demo.StriverSDESheet.LinkedList.Day6;

public class Question5 {
    public static void main(String[] args) {
        
    }

    static Node getCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast !=null){
                fast = fast.next;
            }
            slow = slow.next;
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }

    static Node getStartingNode(Node head){
        if(head == null){
            return null;
        }

        Node poi = getCycle(head);
        if(poi == null){
            return null;
        }
        Node slow = head;
        while(slow != poi){
            slow = slow.next;
            poi = poi.next;
        }
        return slow;
    }
}
