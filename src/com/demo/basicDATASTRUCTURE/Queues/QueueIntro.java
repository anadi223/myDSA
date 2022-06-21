package com.demo.basicDATASTRUCTURE.Queues;

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
        

    }
}
