package com.demo.StriverSDESheet.Arrays.Day1;

import java.util.ArrayList;

//https://www.codingninjas.com/codestudio/problems/630526?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
public class Question4 {
    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};
        ArrayList<Integer> subArray = new ArrayList<>();
        //int ans = findSubArray(arr, subArray);
        int ans = findSubArrayUsingKadaneAlgorithm(arr, subArray);
        System.out.println("The max sum of sub array is" + ans);

        for(int i=subArray.get(0); i<subArray.get(1);i++){ //subArray.get(0) ye kya hai i ki posiiton aur subarray.get(1) hai j ki position toh i to j loop chalao aur print kr do subarray
            System.out.print(arr[i] + " ");
        }
    }
    
    // Time complexity is O(N)2 hai 
    static int findSubArray(int[] arr, ArrayList<Integer> subArray){
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int curr_sum=0;
            for(int j=i;j<arr.length;j++){
                curr_sum+=arr[j];
                if(curr_sum>max_sum){
                    subArray.clear();
                    max_sum=curr_sum;
                    subArray.add(i); // subarray i -->> j i se leke j tak rhega naa toh hm wo le rhe bs
                    subArray.add(j);
                }
            }
        }
        return max_sum;
    }
    //*Optimised apporach using KADANE's ALGORITHM */
    static int findSubArrayUsingKadaneAlgorithm(int[] arr,ArrayList<Integer> subarray){
        int msf=arr[0]; // max so far
        int meh = 0; // max end here 
        int s=0; // start pointer to check from where the subarray is starting
        
        for(int i =0;i<arr.length;i++){
            meh+=arr[i];

            if(meh>msf){ // msf update kar do agar chota hai toh
                msf=meh;
                subarray.clear();
                subarray.add(s); //start index
                subarray.add(i); // end index
            }

            if(meh <0){
                meh=0; 
                s= i+1;
            }
        }
        return msf;
    }
}
