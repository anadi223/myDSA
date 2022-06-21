package com.demo.basicDATASTRUCTURE.Queues;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/queue-reversal/1
public class QueueReverse {
    public static void main(String[] args) {
        
    }
    //TC O(n) SC O(n)
    static void reverseQueue(Queue<Integer> q){

        if(q.isEmpty()){
            return;
        }

        int num = q.remove();
        reverseQueue(q);
        q.add(num);
    }
}
