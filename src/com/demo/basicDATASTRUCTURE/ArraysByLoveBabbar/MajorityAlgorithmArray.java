package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar;

import java.util.Arrays;
import java.util.HashMap;


public class MajorityAlgorithmArray {
    public static void main(String[] args) {
        UsingHashMap();
        UsingSorting();


    }

    //O(N) time and space is also O(N) as we are creating a hashmap to store the result
    public static void UsingHashMap(){
        int[] arr = {1,2,3,2,1};
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=1;
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i])){
                count = map.get(arr[i])+1;
                if(count>arr.length/2){
                    System.out.println("Majority Element using HashMap" + arr[i]);
                    return;
                }else
                    map.put(arr[i],count);
            }else
                map.put(arr[i],1);
        }
        System.out.println("No Majority Element");
    }

    //Time Complexity O(nlogn)
    public static void UsingSorting(){
        int[] arr = {1,2,3,1,1};
        int element_tracker=0;
        int max_element=-1;
        int count=1;
        int temp = arr[0];
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(arr[i] == temp){
                count++;
            }
            else{
                count=1;
                temp = arr[i];
            }

            if(max_element<count){
                max_element=count;
                element_tracker=arr[i];
            }
            if(max_element>arr.length/2)break;
        }
        System.out.println("Majority Element Using Sorting " + element_tracker);
    }

}
