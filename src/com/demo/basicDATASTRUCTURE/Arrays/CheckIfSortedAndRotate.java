package com.demo.basicDATASTRUCTURE.Arrays;


public class CheckIfSortedAndRotate{

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};

        boolean answer = checkSortedRotated(arr);

        System.out.println(answer);
    }

    static boolean checkSortedRotated(int[] arr){


        int count=0;

        for(int i=1;i<arr.length;i++){

            if(arr[i-1] > arr[i]){
                count++;
            }

        }

        if(arr[arr.length-1] > arr[0]){
            count++;
        }

        return count<=1; // Suppose array agar {1,1,1} aise aaya tohhhh agar count ==1 kiya hota toh result false aa jata
    }

}