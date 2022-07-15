package com.demo.StriverSDESheet.Arrays.Day4;

import java.util.HashMap;

//https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
public class Question5 {
    public static void main(String[] args) {
        
    }
    //TC O(n2 ) TLE MAREGA LEKIN DENA HAI 
    public int subArrayWithGivenXORAppraoch1(int[] A, int B) {
        int count=0;  // ye wala method is same as previous question appraoch 1 
        for(int i=0;i<A.length;i++){
            int current_xor =0;
            for(int j=i;j<A.length;j++){
                current_xor^=A[j];
                if(current_xor == B){
                    count++;
                }
            }
        }
        return count;
    }
    //TC O(nlogn) SC O(n)
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> frequency = new HashMap<Integer,Integer>(); 
           int count = 0; // subarray count krega
           int current_xor = 0; //current xor ke liye
           int n = A.length;
           for(int i = 0;i<n;i++) { 
            current_xor = current_xor ^ A[i];  //take the xor 
               if(frequency.get(current_xor^B) != null)  // check if Y is there in the hashmap -- Y is XOR^K k here is B k wo element hai jiske against nikal rhje
               count += frequency.get(current_xor ^ B);  // agar mil jaaye toh count bdha do
               if(current_xor == B) { // if xor is equal to the K then increase count
                count++; 
               }
               if(frequency.get(current_xor) != null) 
               frequency.put(current_xor, frequency.get(current_xor) + 1); // agar phle se hai toh count bdha do
               else 
               frequency.put(current_xor, 1);  // wrna first time me add kr do 
           }
           return count; 
       }

}
