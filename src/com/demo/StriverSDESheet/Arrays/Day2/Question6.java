package com.demo.StriverSDESheet.Arrays.Day2;

//https://www.codingninjas.com/codestudio/problems/615?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
//COUNT INVERSION IMPORTANT QUESTION
public class Question6 {
    public static void main(String[] args) {
        int[] arr = {8,4,2,1,0};
        int ans =countInversionApproach1(arr);
        System.out.println(ans);
    }

    //TC O(n square)  do loop chalao aur array compare kar do //!BRUTE FORCE
    static int countInversionApproach1(int[] arr){
    int count =0;
    for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++)
        if(arr[j-1] > arr[j]){
            count++;
        }
    }
    return count;
    }


    static int countInversionApproach2(int[] arr){

    }

    
}
