package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;

public class ReverseAStringUsingStack {
    public static void main(String[] args) {
         String s = "ANADI";

         Stack<Character> stack = new Stack<>();

         for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            stack.push(temp);
         }

         while(stack.isEmpty() == false){
            System.out.print(stack.pop());
         }

    }
}
