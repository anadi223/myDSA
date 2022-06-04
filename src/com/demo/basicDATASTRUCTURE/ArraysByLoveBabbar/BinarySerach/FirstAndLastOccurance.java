package com.demo.basicDATASTRUCTURE.Arrays.BinarySerach;

//https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118820/offering/1381880?leftPanelTab=1
//Notes Q1 BINARY SEARCH
public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3};
        int key=2;
        int firstAnswer = firstOccurrence(arr,key);
        int lastAnswer = lastOccurrence(arr,key);
        System.out.println(firstAnswer);
        System.out.println(lastAnswer);

    }

    public static int firstOccurrence(int[] arr, int key) {
        int start = 0;
        int end=arr.length-1;
        int ans=-1; //to store the answer

        int mid = start + (end-start)/2;

        while(start<=end){

            if(arr[mid] == key){
                ans = mid;  // store the answer
                end = mid-1;  // bhaiya hmko left most occurrence nikalna hai toh hm end ko update kr rhe jaise mid change ho phir se aur hm left most wale part me wapis jaaye
            }else if(arr[mid]<key){
                start = mid+1;
            }else if(arr[mid] >key){
                end = mid-1;
            }
            mid = start + (end-start)/2;
        }
        return ans;

    }

    public static int lastOccurrence(int[] arr, int key) {
        int start = 0;
        int end=arr.length-1;
        int ans=-1; //to store the answer

        int mid = start + (end-start)/2;

        while(start<=end){

            if(arr[mid] == key){
                ans = mid; //store the answer
               start=mid+1; // bhaiya hmko right most occurrence niaklana hai toh we need to update start so that mid also gets updated
            }else if(arr[mid]<key){
                start = mid+1;
            }else if(arr[mid] >key){
                end = mid-1;
            }
            mid = start + (end-start)/2;
        }
        return ans;

    }
}
