package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;

//https://www.codingninjas.com/codestudio/problems/redundant-brackets_975473?leftPanelTab=0?source=youtube&campaign=Lovebabbarcodestudio&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio
public class RedundantBrackets {
    public static void main(String[] args) {
        String s = "((a+(b*c)))";
        boolean ans = findRedundant(s);
        System.out.println(ans);
    }

     static boolean findRedundant(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/'){ // Check karo agar opening bracket ya koi operator ho toh stack me push kr do
                st.push(ch);
            }
            else{
                if(ch == ')') { // jab closing bracket aaye //!We dont care about letters kukyi hm wo stack me nhi daal rhe
                    boolean isRedundant = true;

                    while(st.peek() != '('){ //check karo jab tk opening bracket na mile
                        char top = st.peek();

                        if(top == '+' || top == '-' || top == '*' || top == '/'){
                            isRedundant = false; // agar ek operator mil gya that means the brackets are not redundant
                        }
                        st.pop(); // pop krte jao jab tk opening bracket na mile
                    }
                    if(isRedundant == true){
                        return true;
                    }
                    
                    st.pop(); // ye wala pop is liye kiya ki while loop sirf tab tak pop krega jab tak opening bracket nhi milta toh opening bracket to abhi bhi stack me hai na toh pop it
                }

            }

        }
        return false;
     }
}
