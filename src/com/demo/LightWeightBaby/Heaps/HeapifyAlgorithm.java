package com.demo.LightWeightBaby.Heaps;

//! TO BUILD MAX HEAP 
public class HeapifyAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-1,54,53,55,52,50};
        int n =  5;
        for(int i = n/2; i>0;i--){
           heapify(arr, n, i); // 0 to n/2 tak ke element ko hi process 
           //krna hai as n/2 -- to n wale elements is the leaf elements that does not need to be processed
        }
        System.out.println(" Printing Max heap");
        for(int i = 1; i<=n;i++){ // 1 se kar rhe kyuki 0th index has nothing
            System.out.print(arr[i] + " ");
        }
    }
    // TC O(log n)
    static void heapify(int[] arr, int n, int i){
        int largest = i; // isko sahi jagah pe leke jana hai
        int left = 2*i;
        int right = 2*i + 1;
        if(left < n && arr[largest] < arr[left]){ //left < n bound check kar rhe
            largest = left; // largest ka pointer change krna rhega
        }

        if(right < n && arr[largest] < arr[right]){
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
//& ---------------------------------------------------------------------------------------------------------------------------------------------------------- &
    //https://www.codingninjas.com/codestudio/problems/build-min-heap_1171167?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
    public static int[] buildMinHeap(int[] arr)
	{
        int n = arr.length;
		for(int i = n/2-1; i>=0;i--){
           heapify(arr, n, i); // 0 to n/2 tak ke element ko hi process 
           //krna hai as n/2 -- to n wale elements is the leaf elements that does not need to be processed
        }
        return arr;
	}
    static void heapifyMin(int[] arr, int n, int i){
        int smallest = i; // isko sahi jagah pe leke jana hai
        int left = 2*i +1; //!0 based indexing me left and right formula me +1 karenge
        int right = 2*i + 2; 
        if(left < n && arr[smallest] > arr[left]){ //left < n bound check kar rhe
            smallest = left; // largest ka pointer change krna rhega
        }

        if(right < n && arr[smallest] > arr[right]){
            smallest = right;
        }

        if(smallest != i){ // mtlb largest update hogya agar nhi hua hota toh wo i ke equal hota
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;

            //aage wale tree me bhi check kar lo ki swap krne ke baad wo element sahi jagah hai ya nhi
            heapify(arr, n, smallest);
        }
    }
}


