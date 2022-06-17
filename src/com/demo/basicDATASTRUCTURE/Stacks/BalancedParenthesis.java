package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;
//!IMPORTANT QUESTION COMES IN INTERVIEW AS WELL AS EXAM
//https://www.codingninjas.com/codestudio/problems/valid-parenthesis_795104?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0
public class BalancedParenthesis {
    public static void main(String[] args) {
        String expression = "{{}";
        boolean ans = isValidParenthesis(expression);
        System.out.println(ans);
    }
    static boolean isValidParenthesis(String expression){

        Stack<Character> s = new Stack<>();
        for(int i=0; i<expression.length(); i++) {
            
            char ch = expression.charAt(i);
            
            //if opening bracket, stack push
            //if close bracket, stacktop check and pop
            
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }
            else
            {
                //for closing bracket
                if(!s.empty()) {
                     char top = s.peek();
                     if( (ch == ')' && top == '(') || 
                        ( ch == '}' && top == '{') || 
                        (ch == ']' && top == '[') ) {
                         s.pop();
                     }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                } 
            }  
        }
       
       if(s.empty())
           return true;
       else
           return false;
        
    }
}
