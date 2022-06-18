package com.demo.StriverSDESheet.Arrays.Day1;

//https://www.codingninjas.com/codestudio/problems/631055?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
public class Question5 {
    public static void main(String[] args) {
      int[] arr = {1,2,0,0,2,1,1};
      //int[] ans = sort012Appraoch2(arr);
      int[] ans = sort012Approach3(arr);
      for(int x: ans){
        System.out.print(x+ " ");
      }
    }


    //!Appraoch 1 sort kar do he he O(nlogn)


    //* Appraoch two count le lo 0 1 2 ka  TC O(2N) SC O(1)*/

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


        int index=0;
        for(int i=0;i<arr.length;i++){
            if(zeroCount!=0){
                arr[index++] = 0;
            zeroCount--;
            }
            else if(oneCount!=0){
                arr[index++] =1;
                oneCount--;
            }
            else if(twoCount!=0){
                arr[index++] = 2;
            }
        }
        return arr;
    }

    // sort in one traversal with TC O(N) and SC O(1) //? Variation of dutch national flag algorithm
    static int[] sort012Approach3(int[] arr){
        int low =0, mid =0; // Take three pointers low mid and high 
        int high = arr.length-1;

        for(int i=0;i<arr.length;i++){
            //MID TRAVERSE krwao 
            if(arr[mid] ==0){  //Agar mid tmhra 0 dekha toh low poisiton ke array ko swap krwa do mid position wale se aur low++ and mid++
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] == 1){ //agar mid tmhra 1 hai toh sirf mid++
                mid++;
            }
            else if(arr[mid] ==2){ //agar mid tmhra 2 hai toh swap krwao high aur mid ko and high-- only
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        return arr;
    }
}
