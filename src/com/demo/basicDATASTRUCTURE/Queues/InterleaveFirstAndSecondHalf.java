package com.demo.basicDATASTRUCTURE.Queues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.codingninjas.com/codestudio/problems/interleave-the-first-half-of-the-queue-with-the-second-half_1169450
public class InterleaveFirstAndSecondHalf {
    public static void main(String[] args) {
        Queue<Integer> q =  new LinkedList<>(List.of(10,20,30,40,50,60,70,80,90,100));
        interLeaveQueue(q);
        for(int x  : q){
            System.out.print( x + " ");
        }
    }
    //TC O(n) SC O(n)
    static void interLeaveQueue(Queue<Integer> q){
        Queue<Integer> newQ = new LinkedList<>();

        int mid = q.size()/2;

        for(int i=0;i<mid;i++){ // first half ko ek nayi queue me daal do
            int val = q.poll();
            newQ.add(val);
        }


        while(newQ.isEmpty() != true){  // ab kya karo 
            int val = newQ.poll(); // new q ka value nikalo
            q.add(val); // aur add kar do old queue me
            val = q.poll(); // phr kya karo purani queue ka aage se element nikalo
            q.add(val); // peeche add kar do
        }

    }
}
