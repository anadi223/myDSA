package com.demo.StriverSDESheet.LinkedList.Day6;

import java.util.HashMap;

public class Question2 {
    public static void main(String[] args) {
        
    }

    //TC O(n) SC O(n)
    static boolean detectCycleApproach1(Node head){
        HashMap<Node,Boolean> map = new HashMap<>();
        Node temp = head;

        while(temp != null){
            if(map.containsKey(temp)){
                return true;
            }else{
                map.put(temp, true);
            }
            temp =temp.next;
        }
        return false;
    }


    static Node detectCycleFloydDetection(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            slow = slow.next;
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }

}
