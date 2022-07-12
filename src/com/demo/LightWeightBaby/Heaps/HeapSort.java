package com.demo.LightWeightBaby.Heaps;

//TC O(nlogn)
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {-1,54,53,55,52,50};
        int n =5;
        for(int i = n/2; i>0;i--){
            heapify(arr, n, i);
        }

        heapSort(arr, n);
        for(int i = 1; i<=n;i++){
            System.out.print(arr[i]+ " ");
        }
        
    }

    static void heapSort(int[] arr, int n){
        int size = n;
        while(size > 1){
            //step 1 swap
            int temp = arr[size];
            arr[size] = arr[1];
            arr[1] = temp;
            //step 2 size decrease kr do kyuki ek element toh already process hogya na
            size --;

            //step 3:: heapify kar do
            heapify(arr, size, 1);
        }
    }

    static void heapify(int[] arr, int n, int i){
        int largest = i; // isko sahi jagah pe leke jana hai
        int left = 2*i;
        int right = 2*i + 1;
        if(left <=n && arr[largest] < arr[left]){ //left <= n bound check kar rhe <= mtlb 1 based indexing hai 
            largest = left; // largest ka pointer change krna rhega
        }

        if(right <=n && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest != i){ // mtlb largest update hogya agar nhi hua hota toh wo i ke equal hota
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            //aage wale tree me bhi check kar lo ki swap krne ke baad wo element sahi jagah hai ya nhi
            heapify(arr, n, largest);
        }
    }
}
