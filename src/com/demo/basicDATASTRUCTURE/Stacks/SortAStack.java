package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;

//https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=love-babbar-dsa-sheet-problems&leftPanelTab=1
public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(2);
        stack.push(33);
        stack.push(54);
        sortStack(stack);

        for(int x: stack){
            System.out.print(x + " ");
        }

    }

    static void sortStack(Stack<Integer> stack){
        if(stack.empty()){ // Jab Stack khali hai toh wapis aa jao
            return;
        }

        int num = stack.pop(); // top element ko nikalo

        sortStack(stack); // recursive call krte rho jab tk stack khali na ho

        sortedInsert(stack,num); // jab khali hoke wapis aane lgo toh jo num mila hai usko sorted order me insert
    }
    static void sortedInsert(Stack<Integer> stack, int num){
        if(stack.empty() || (stack.peek() < num) ){ // base case || phla element jo stack me hai wo agar chota hai jo num nikale ho upar sortStack me toh usko stack me push kr do
            stack.push(num);
            return;
        }

        int temp = stack.pop(); // nikalte rho element
        sortedInsert(stack, num); // recursive call
        stack.push(temp); // wapis se daal do element
    }
}
