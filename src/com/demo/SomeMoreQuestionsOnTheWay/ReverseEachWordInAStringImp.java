package com.demo.SomeMoreQuestionsOnTheWay;

import java.util.Stack;
//https://practice.geeksforgeeks.org/problems/reverse-each-word-in-a-given-string1001/1#
public class ReverseEachWordInAStringImp {
    public static void main(String[] args) {
        
    }

   static String reverseWords(String S)
    {
        // your code here
        StringBuilder sb = new StringBuilder("");
        Stack<Character> s = new Stack<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            
            if(c!= '.'){
                s.push(c);
            }else{
                while(s.empty() == false){
                    sb.append(s.pop());
                }
                sb.append('.');
            }
        }
        while(s.empty() == false){
            sb.append(s.pop());
        }
        return sb.toString();
    }
}


