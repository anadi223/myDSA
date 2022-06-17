package com.demo.basicDATASTRUCTURE.Stacks;

//https://www.codingninjas.com/codestudio/problems/two-stacks_983634
public class TwoStackProblem {
    public static void main(String[] args) {
        
    }    
}


//! TC O(1) SC O(1)
class TwoStack{
    int top1; //Top1 ko left se right leke jana
    int top2; // top 2 ko right se left leke jana
    int[] arr;
    int size;

    TwoStack(int size){
        this.size = size;
        top1=-1;
        top2 = size;
        arr = new int[size];
    }

    void push1(int element){
        if(top2-top1>1){
            top1++; //!Remember to increment top1 first then insert at currently top 1 was on -1,, aur element enter hona start krega 0 se for first push
            arr[top1] = element;
        }
        else{
            System.out.println("Stack Overflow");
        }
    }

    void push2(int element){
        if(top2-top1>1){ 
            top2--;
            arr[top2] = element;
        }else{
            System.out.println("Stack overflow");
        }
    }

    int pop1(){
        if(top1>0){
            int ans = arr[top1];
            top1--;
            return ans;
        }
        else{
            return -1;
        }
    }

    int pop2(){
        if(top2< size){ //*Top 2 right se monitor kr rhe naa toh wo size se chota hona chaihye */
            int ans = arr[top2];
            top2++;
            return ans;
        }
        else{
            return -1;
        }
    }
}