package com.demo.StriverSDESheet.Arrays.Day3;

import java.util.ArrayList;
import java.util.HashMap;

//Majority Elements(>N/3 times) | Find the elements that appears more than N/3 times in the array
//https://leetcode.com/problems/majority-element-ii/
public class Question4 {
    public static void main(String[] args) {
        
    }
    //Brute force:: Simply count the no. of appearance for each element using nested loops and whenever you find the count of an element greater than N/3 times, that element will be your answer.
    //TC O(n2) SC O(1)
    static ArrayList<Integer> findMajorityElementApproach1(int arr[] , int n){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int count = 1;
            for(int j=i+1;i<n;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > (n/3)){
                ans.add(arr[i]);
            }
        }
        return ans;
    }
        //TC O(n)  S O (N)
    static ArrayList<Integer> findMajorityElementApproach2(int[] arr, int n){
        HashMap<Integer,Integer> map = new HashMap<>(); // map le lo aur count karte jao har ek element ko array me
        ArrayList<Integer> ans = new ArrayList<>(); // ans store krwane ke liye

        for(int i=0;i<n;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1 ); // map me put karo value agar nhi hai toh 0+1 aur hai toh wo value +1 
        }

        for(int x : map.keySet()){ // key utha lo key mtlb arr[i]
            if(map.get(x) > (n/3)){
                ans.add(x);
            }
        }
        return ans;
    }
    //*EXTENDED BOYER MOORE APPROACH  TC O(n) SC o(1)
    static ArrayList<Integer> findMajorityElementApproach3(int[] arr, int n){
        int num1 = -1, num2 = -1, count1 = 0, count2 =0; // num1 is your current freq element and num2 is second curr freq element count1 will mark num1 count 2 will mark num2
        for(int i=0;i<n;i++){
            if(arr[i] == num1){  // agar num1 ke barabar toh count1 bdha do
                count1++;
            }else if(arr[i] == num2){ // agar num2 ke barabar toh count2 bdha do
                count2++;
            }else if(count1 ==0){ // if count1 0 toh num1 ko current element ke barabar kar do
                num1 = arr[i];
                count1 = 1; // count =1 kar do jaise is case me naa aaye
            }else if(count2 ==0){
                num2 = arr[i];
                count2 = 1;
            }else{
                count1--; // baaki saare case me decrement kar do count ka
                count2--;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        count1=0; // ab count ko reset karo as upar wale step se hmare paas wo do number aa gye hai jo majority element ho sakte hai
        count2=0;
        for(int i=0;i<n;i++){ // loop run kiya check karne ke liye ki wo majority element hai ya nahi jo do number nikale hai hmne
            if(arr[i] == num1){
                count1++;
            }else if(arr[i] == num2){
                count2++;
            }
        }
        if(count1 >(n/3)){
            ans.add(num1); 
        }
        if(count2 > (n/3)){
            ans.add(num2);
        }
        return ans;
    }
}
