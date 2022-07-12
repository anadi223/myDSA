package com.demo.LightWeightBaby.Heaps;

public class HeapIntro {
    public static void main(String[] args) {
        HeapImplementationByArray heap = new HeapImplementationByArray();
        heap.insert(50);
        heap.insert(55);
        heap.insert(53);
        heap.insert(54);
        heap.print();
        

    }
}

//TC O(log n)
class HeapImplementationByArray{
    int arr[] = new int[100];
    int size =0;

    void insert(int val){ // value ko end me dalna hai
        size = size+1; // size bdha do array ka by 1 
        int index = size; // index nikal lo
        arr[index] = val; // aur us index pe value daal do array me

        //Now the next step is to make the value placed at the right position

        while(index >1){
            int parent = index/2; //(parent niukalna hai and to find parent it is index/2)

            if(arr[parent] < arr[index]){ // agar parent chota hai toh swap kar do 
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
            }
            else{
                return;
            }
        }
    }
    // TC O(log n)
    void delete(){
        if(size == 0){
            System.out.println("Nothing to delete");
            return;
        }

        arr[1] = arr[size]; //put last element into first index
        size--; //last node delete mtlb size kam kr diya toh koi access nhi kr skega 

        int i = 1;
        while(i<size){ // root node ko sahi jagah leke ja rhe
            int leftIndex = 2*i;
            int rightIndex = 2*i+1;
            if(leftIndex < size && arr[i] < arr[leftIndex]){
                int temp = arr[i];
                arr[i] = arr[leftIndex];
                arr[leftIndex] = temp;
                i = leftIndex;
            } else if(rightIndex < size && arr[i] <arr[rightIndex]){
                int temp = arr[i];
                arr[i] = arr[rightIndex];
                arr[rightIndex] = temp;
                i = rightIndex;
            }
            else{
                return;
            }
        }

    }

    void print(){
        for(int i = 1; i<=size;i++){ //* 1 se kyu chla rhe always remember 0th Index pe kuch nahi daal rhe hai */
            System.out.print(arr[i] + " ");
        }
    }
}