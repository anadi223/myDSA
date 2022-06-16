package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;

public class StackIntro {
    public static void main(String[] args) {
        
        // Stack<Integer> stack = new Stack<>();

        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // while(stack.isEmpty() == false){
        //     System.out.println(stack.pop()); // POP kar rhe toh size bhi zero ho jayega
        // }

        // stack.push(12);
        // System.out.println(stack.size());

        StackUsingArray arrayImpl = new StackUsingArray(5);
        arrayImpl.push(2);
        arrayImpl.push(3);
        arrayImpl.push(4);
      //  arrayImpl.printStack();
        arrayImpl.pop();
        // arrayImpl.pop();
        // arrayImpl.pop();
        // arrayImpl.pop();
        int peek = arrayImpl.peek();
        System.out.println(peek);
        boolean isEmpty = arrayImpl.isEmpty();
        System.out.println(isEmpty);
    }
    
}


//! STACK IMPLEMENTATION USING ARRAYS:::

class StackUsingArray{
    //*Properties of STACK */
    int top; // index jo array me store krega 
    int[] arr; //array implementation ke liye
    int size; // array ka size

    //*Constructor of Stack */
    public StackUsingArray(int size){ //Constructor is class ka 
        this.size = size;
        arr = new int[size];
        top =-1;
    }

    //!Functions of stack using array implementation
    void push(int element){
        if(size-top>1){ // Checking if space available
            top++; // top ko bdhao index chahiye jahan pe element store hoga
            arr[top] = element;
        }else{
            System.out.println("Stack Overflow error");
        }
    }
    void pop(){
        if(top>0){ //check karo top khali nhi hona chahiye
            top--;
        }else{
            System.out.println("Stack Underflow error");
        }
    }
    boolean isEmpty(){
        if(top ==-1){ // agar top -1 hoga mtlb khali hai
            return true;
        }
        return false;
    }
    int peek(){
        if(top>0){ // top 0 se bda hona chhaiye kuch dekhne ke liye
            return arr[top];
        }
        else
            System.out.println("Stack is empty");
            return -1;
    }
    void printStack(){
        for(int x: arr){
            System.out.println(x);
        }
    }
}