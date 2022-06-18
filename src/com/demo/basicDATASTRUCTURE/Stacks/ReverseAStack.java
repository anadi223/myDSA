package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;

//https://www.codingninjas.com/codestudio/problems/reverse-stack-using-recursion_631875?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0
public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverseStack(stack);

        for(int x: stack){
            System.out.print(x + " ");
        }

    }

    static void reverseStack(Stack<Integer> stack){

        if(stack.empty()){  //BASE CASE
            return;
        }

        int num = stack.pop(); //ELEMENT KO NIKALO TOP WALE
 
        reverseStack(stack); //RECURSION REVERSE KARKE DEGA BAAKI ELEMENT

        insertAtBottom(stack,num); // Jo ELEMENT NIKALA HAI USKO NEECHE DALNA HAI
    }
    static void insertAtBottom(Stack<Integer> stack, int element){
        if(stack.empty()){
            stack.push(element);
            return;
        }

        int num = stack.pop();

        insertAtBottom(stack, element);
        stack.push(num);

    }
}
