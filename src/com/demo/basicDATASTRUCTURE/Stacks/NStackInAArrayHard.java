package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/n-stacks-in-an-array_1164271?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0
public class NStackInAArrayHard {
    public static void main(String[] args) {
        
    }

}


class NStack{

    int[] arr; // main array jahan dalna hai    
    int[] top; // stack ke top ko maintain krne ke liye
    int[] next; // agla free space kaun se index pe hai aur top ke next pointer kaun sa hai do kaam hai is next ka

    int n,s;
    int freespot; // free jahag ka index 
    //N -- Stack ka size S--> array ka size
    NStack(int N, int S){
        n=N;
        s=S;

        arr = new int[S];
        top = new int[N];
        next = new int[S];

        Arrays.fill(top, -1); // phle top -1 hoga har stack ka

        //Initialize next
        for(int i=0;i<S;i++){
            next[i] = i+1; // jab next empty hai toh next btayega next free position ka index toh 0 index btayega next available position which is 1 toh whi initialize krwa do
        }
        //update next last value
        next[S-1] = -1; // last index -1 ko point krega

        freespot = 0; // initially freespot to 0
    }

     boolean push(int x, int m){
        if(freespot == -1){
            return false;
        }

        int index =freespot;

        // update freespot
        freespot = next[index];
        //insert element in array
        arr[index] = x;

        //update next

        next[index] = top[m-1];

        top[m-1] = index;

        return true;
    }
    //push ka ulta
    int pop(int m){
        if(top[m-1] == -1){
            return -1; //Stack underflow
        }
        int index = top[m-1];

        top[m-1] = next[index];

        next[index] = freespot;

        freespot = index;

        return arr[index];
    }

}