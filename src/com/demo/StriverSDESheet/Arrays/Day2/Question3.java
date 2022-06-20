package com.demo.StriverSDESheet.Arrays.Day2;


//https://www.codingninjas.com/codestudio/problems/1214628?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
public class Question3 {
   public static void main(String[] args) {

   } 

   static int[] sortArray(int arr1[] , int arr2[] , int n, int m){

    int i=m-1,j=n-1;
    int k= m+n-1;

    while(j>=0){
        if(i>=0 && arr1[i] > arr2[j]){
            arr1[k--] = arr1[i--];
        }else{
            arr1[k--] = arr2[j--];
        }
    }
    return arr1;
   }
}
