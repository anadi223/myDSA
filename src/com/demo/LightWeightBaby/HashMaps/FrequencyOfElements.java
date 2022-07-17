package com.demo.LightWeightBaby.HashMaps;

import java.util.HashMap;

public class FrequencyOfElements {
    public static void main(String[] args) {
     
        int[] arr = {10,12,10,15,10,20,12,12};
        HashMap<Integer,Integer> map  = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        System.out.println(map);
    }
}
