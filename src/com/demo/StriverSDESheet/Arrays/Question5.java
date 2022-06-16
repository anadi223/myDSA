package com.demo.StriverSDESheet.Arrays;

//https://www.codingninjas.com/codestudio/problems/631055?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
public class Question5 {
    public static void main(String[] args) {
      int[] arr = {1,2,0,0,2,1,1};
      int[] ans = sort012Appraoch2(arr);
      
      for(int x: ans){
        System.out.print(x+ " ");
      }
    }


    //!Appraoch 1 sort kar do he he O(nlogn)


    //* Appraoch two count le lo 0 1 2 ka  TC O(N) SC O(N)*/

    static int[] sort012Appraoch2(int[] arr){
        int zeroCount =0;
        int oneCount =0;
        int twoCount =0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                zeroCount++;
            }
            else if(arr[i] ==1){
                oneCount++;
            } else if(arr[i] == 2){
                twoCount++;
            }
        }

        int[] ans = new int[arr.length];
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(zeroCount!=0){
                ans[index++] = 0;
            zeroCount--;
            }
            else if(oneCount!=0){
                ans[index++] =1;
                oneCount--;
            }
            else if(twoCount!=0){
                ans[index++] = 2;
            }
        }
        return ans;
    }

    // sort without using extra space i.e. in place
    static void sort012Approach3(int[] arr){

    }
}
