package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;

//? https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1/
public class CelebrityProblemHard {
    public static void main(String[] args) {
        int[][] M ={{0,1,0},{0,0,0},{0,1,0}};
        int ans = findCelebrity(M, M.length);
        System.out.println(ans);
    }

    static int findCelebrity(int[][] M, int n){
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n;i++){
            s.push(i); //stack me saare element ko store krwa do
        }

        while(s.size() >1){ // jab tak stack me sirf ek element na bache loop chlao
            int a = s.pop(); //row index
            int b = s.pop(); // col index

            if(knows(M,a,b)){ // check karo ki A kya b ko janta hai if yes toh bhaiya A toh celeb nhi hoga na because celeb doesnt knows anyone
                s.push(b);
            }else{
                s.push(a);
            }
        }

        int candidate = s.peek(); //While loop se bahr aaoge toh sirf ek element bchega that can be //!POTENTIAL CANDIDATE

        boolean rowCheck = false; // check for potential candidates
        int zeroCount=0;
        for(int i=0;i<n;i++){ // Jo bhi index potenital candidate hoga uski row ke saare element zero hone chahiyue
            if(M[candidate][i]==0){
                zeroCount++;
            }
        }
        if(zeroCount == n){
            rowCheck = true;
        }

        boolean colCheck = false;
        int oneCount = 0;
        for(int i=0;i<n;i++){ // jo bhi potential candidate hoga uski col ke saare element 1 hone chahiye except us index ke position pe as wo 0 hoga
            if(M[i][candidate] == 1){
                oneCount++;
            }
        }
        if(oneCount == n-1){
            colCheck = true;
        }

        if(rowCheck == true && colCheck == true){ // agar dono condition satisfy hogyi toh bhaiya wo element is celebrity
            return candidate;
        }
        else{
            return -1;
        }
    }
    static boolean knows(int[][] M , int a , int b){
        if(M[a][b] == 1){ // agar a index aur b index 1 hai toh A knows B return true
            return true;
        }
        else{
            return false;
        }
    }

}
