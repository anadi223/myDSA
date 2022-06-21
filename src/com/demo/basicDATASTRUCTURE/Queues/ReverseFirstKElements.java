package com.demo.basicDATASTRUCTURE.Queues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1/
public class ReverseFirstKElements {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(List.of(1,2,3,4,5));
        modifyQueue(q, 3);

        for(int x : q){
            System.out.print( x + " ");
        }
    }

    static Queue<Integer> modifyQueue(Queue<Integer> q , int k){
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<k;i++){
            int val = q.poll();
            s.push(val);
        }

        //fetch from stack and push into queue
        while(!s.empty()){
            int val = s.pop();
            q.add(val);
        }

        //fetch first n-k elements from queue and add at end
        int a = q.size()-k;
        
        while(a>0){
            int val = q.poll();
            q.add(val);
            a--;
        }
    
        return q;
    }
}
