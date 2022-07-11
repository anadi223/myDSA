package com.demo.StriverSDESheet.Arrays.Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        int arr[] = {1,0,-1,0,-2,2}; 
		int target = 0;
		
		List<List<Integer>> ls = fourSum(arr, target);
		//System.out.println("raj");
		for(int i = 0;i<ls.size();i++) {
		    for(int j = 0;j<ls.get(i).size();j++) {
		        System.out.print(ls.get(i).get(j) + " "); 
		    }
		    System.out.println(); 
		}
    }

    public static List<List<Integer>> fourSum(int[] arr, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(arr == null || arr.length ==0){ // null check
            return result;
        }

        int n = arr.length;

        Arrays.sort(arr); // sort kar do array

        for(int i=0;i<n;i++){
            for(int j = i+1 ; j<n;j++){
                int target_2 = target - arr[i] - arr[j]; //remaining element sum mtlb maine do pointer toh fix kr diye i aur j aur usko target me se minus kiya aur ek naya target bnaya 
                //now the target_2 kya hua ek naya sub problem ban gya which is basically two sum problem now
                //following two pointer
                int front = j+1; // left pointer
                int back = n-1; // right pointer

                while(front < back){
                    int two_sum = arr[front] + arr[back];
                    if(two_sum < target_2){
                        front++;
                    }else if(two_sum > target_2){
                        back--;
                    }
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[front]);
                        quad.add(arr[back]);
                        result.add(quad);

                        //processing the duplicates for number 3
                        while(front < back && arr[front] == quad.get(2)) ++ front;

                        //Processing the duplicate for number 4
                        while(front < back && arr[back] == quad.get(3)) --back;
                    }
                }

                //Processing the duplicate for number 2
                while(j +1 < n && arr[j+1] == arr[j]) ++j;
            }
            //Processing the duplicate for number 1
            while(i +1 < n && arr[i+1] == arr[i]) ++i;
        }
        return result;
    }
}
