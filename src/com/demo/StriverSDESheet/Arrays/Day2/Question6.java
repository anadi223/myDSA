package com.demo.StriverSDESheet.Arrays.Day2;

//https://www.codingninjas.com/codestudio/problems/615?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
//COUNT INVERSION IMPORTANT QUESTION
public class Question6 {
    public static void main(String[] args) {
        int[] arr = {8,4,2,1,0};
        //int ans =countInversionApproach1(arr);
        int ans = countInversionApproach2(arr);
        System.out.println(ans);
    }

    //TC O(n square)  do loop chalao aur array compare kar do //!BRUTE FORCE
    static int countInversionApproach1(int[] arr){
    int count =0;
    for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++)
        if(arr[j-1] > arr[j]){
            count++;
        }
    }
    return count;
    }


    static int countInversionApproach2(int[] arr){
        int ans = mergeSort(arr, 0, arr.length-1);
        return ans;
    }

    static int mergeSort(int[] arr, int start, int end){
        int inversionCount=0;

        if(start<end){
            int mid = start+ (end -start)/2;

           inversionCount+= mergeSort(arr, start, mid); // left array me kitte inversion bane
          inversionCount+=  mergeSort(arr, mid+1, end); // right me kitte inversion bane
           inversionCount+= merge(arr, start, end); // dono array ko merge krne pe kitte inversion bane
        }
        return inversionCount;

    }

    static int merge(int[] arr, int start, int end){
        int inversionCount=0;

        int mid = start+ (end-start)/2;

        int len1 = mid-start+1; //length of first array before mid
        int len2 = end -mid; // length of second array after mid 

        int[] first = new int[len1]; 

        int[] second = new int[len2];

        //Copy the values of sorted divided into two arrays in each newly created arrays
        //so basically we are creating two arrays left and right jo upar kiya hai sort uska alag alag array bana lo
        int mainArrayIndex=start;
        for(int i=0;i<len1;i++){
            first[i] = arr[mainArrayIndex++];
        }
        mainArrayIndex = mid+1;
        for(int i=0;i<len2;i++){
            second[i] = arr[mainArrayIndex++];
        }

        //Now merge two sorted array 

        int index1 = 0,index2 =0;
        mainArrayIndex=start;

        while(index1<len1 && index2< len2){
            if(first[index1] < second[index2]){
                arr[mainArrayIndex++] = first[index1++];
            }else{
                arr[mainArrayIndex++] = second[index2++];
                inversionCount+=len1-index1; // because a[i] > b[j] toh inversion count krna hai (len1-index --> jitte bhi elements honge b[j] me wo sabhi ke sabhi chote honge a[i] wale se aree bhai sorted array hai dono na )
            }
        }

        while(index1<len1){
            arr[mainArrayIndex++]  = first[index1++];
        }
        while(index2<len2){
            arr[mainArrayIndex++]  = second[index2++];
        }
        return inversionCount;
    }

    
}
