package com.demo.basicDATASTRUCTURE.Stacks;
import java.util.Stack;

//https://www.codingninjas.com/codestudio/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0
public class InsertAtBottom {
    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        inputStack.push(3);
        inputStack.push(5);
        inputStack.push(9);
        inputStack.push(2);
        int element =45;
       insertAtBottom(inputStack, element);
        for(int x: inputStack){
            System.out.print(x+ " ");
        }
    }

    static Stack<Integer> insertAtBottom(Stack<Integer> stack, int element){
        solve(stack, element);
        return stack;
    }

    static void solve(Stack<Integer> stack , int element){
        if(stack.empty()){
            stack.push(element);
            return;
        }

        int num = stack.pop();
        solve(stack, element);
        stack.push(num);
    }
}
