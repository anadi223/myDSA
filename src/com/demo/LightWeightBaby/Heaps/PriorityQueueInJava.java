package com.demo.LightWeightBaby.Heaps;


import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueInJava {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default it will create min heap
        pq.add(10);
        pq.add(15);
        pq.add(20);
        System.out.println(pq); //[10, 15, 20]

        //Max heap
        PriorityQueue<Integer> maxPQ  = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.add(10);
        maxPQ.add(15);
        maxPQ.add(20);
        System.out.println(maxPQ); //[20, 10, 15]

        // functions are same as other collections
        
    }
}
