package com.demo.basicDATASTRUCTURE.Stacks;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1/
public class DeleteMiddleElementFromStack {
    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        inputStack.push(3);
        inputStack.push(5);
        inputStack.push(9);
        inputStack.push(2);
        inputStack.push(4);

        deleteMiddle(inputStack, inputStack.size());

        for(Integer x : inputStack){ //Iterate in stack
            System.out.print(x+ " ");
        }

    }
    static void deleteMiddle(Stack<Integer> inputStack,int size){
        int count =0;
        solve(inputStack,count,size);
    }
    static void solve(Stack<Integer> inputStack, int count, int size){

        if(count == size/2){ //BASE CASE
            inputStack.pop(); //JAiSE HI Count barabar ho mid element ke uda do
            return;
        }

        int num = inputStack.pop(); //sbse top wala element utha ke save kar lo

        solve(inputStack, count+1, size); //Recursive call
        inputStack.push(num); //jo element save kiya tha alag se usko wapis stack pe daal do
    }
}
