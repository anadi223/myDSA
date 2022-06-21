package com.demo.basicDATASTRUCTURE.Queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeIntegerInWindowK {
    public static void main(String[] args) {
        long[] A = {-8,2,3,-6,10};
        long[] ans = printFirstNegative(A, A.length, 2);

        for(long x : ans){
            System.out.print(x + " ");
        }
    }

    static long[] printFirstNegative(long A[] , int N , int K){
        Deque<Integer> dq = new LinkedList<>();

        ArrayList<Long> ans = new ArrayList<>();

        //long[] ans = new long[N];


        //process first window
        for(int i=0;i<K;i++){
            if(A[i] < 0){
                dq.addLast(i);
            }
        }

        //Store ans of first k size window
        if(dq.size()>0){
            ans.add(A[dq.peekFirst()]);
        }else{
           ans.add((long) 0);
        }

        //Process rest windows
        for(int i = K;i<N ;i++){
            //Removal

            if(dq.isEmpty() == false && (i-dq.peekFirst() >=K)){
                dq.pollFirst(); // jab agla element dalna hoga tab ke liye
            }

            if(A[i] <0){
                dq.addLast(i); // add krna hai na jaise first window me add kiya tha
            }

            if(dq.size()>0){
                ans.add(A[dq.peekFirst()]); // aur dq me dekho jo phla element hoga wo 
            }else{
                ans.add((long) 0);
            }
        }

        int size = ans.size(); // answer long me hi chahiye tha bhaiya ko ka karein
        long[] finalAns = new long[size];

        for(int i=0;i<size;i++){
            finalAns[i] = ans.get(i);
        }
        return finalAns;
    }
}
