package com.demo.basicDATASTRUCTURE.Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueIntro {
    public static void main(String[] args) {
        
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        queue.remove();
        System.out.println(queue.size());
        

        System.out.println("--DEQUE-----------");
        Deque<Integer> dq = new LinkedList<>();
        dq.offerFirst(1);
        dq.offerLast(5);
        dq.removeFirst();

        System.out.println(dq.size());

    }
}
