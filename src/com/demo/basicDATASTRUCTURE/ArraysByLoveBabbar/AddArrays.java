package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddArrays {
    public static void main(String[] args) {
        
        int[] arr1 = {1,2,3};
        int n = arr1.length;
        int[] arr2 = {9,9};
        int m = arr2.length;

        int[] answer = addArray(arr1, n, arr2, m);

        for(int X: answer){
            System.out.print(X+ " ");
        }
    }
    

    public static int[]  addArray(int[] arr1, int n , int[] arr2, int m){

        int i=n-1;
        int j = m-1;

        int carry=0;

        ArrayList<Integer> ans = new ArrayList<>();

        while(i>=0 && j>=0){
            int val1 = arr1[i];
            int val2 = arr2[j];

            int sum = val1+ val2 + carry;

            carry = sum/10;
            sum=sum%10;

            ans.add(sum);
            i--;
            j--;
        }


        //case1
        while(i>=0) {
            int sum = arr1[i] + carry;
            carry = sum/10;
            sum = sum%10;
            ans.add(sum);
            i--;
        }

        //case2
        while(j>=0) {
            int sum = arr2[j] + carry;
            carry = sum/10;
            int value = sum%10;
            ans.add(value);
            j--;
        }

        //case3
        while(carry != 0) {
            int sum = carry;
            carry = sum/10;
            sum = sum%10;
            ans.add(sum);
        }

         Collections.reverse(ans);

         int[] answer = new int[ans.size()];
         for(int k=0;k<ans.size()-1;k++){
             answer[k] = ans.get(k);
         }
         return answer;
    }
}
