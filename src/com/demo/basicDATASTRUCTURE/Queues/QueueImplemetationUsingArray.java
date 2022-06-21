package com.demo.basicDATASTRUCTURE.Queues;

//https://www.codingninjas.com/codestudio/problems/queue-using-array-or-singly-linked-list_2099908?leftPanelTab=0?source=youtube&campaign=LoveBabbar_Codestudio&utm_source=youtube&utm_medium=affiliate&utm_campaign=LoveBabbar_Codestudio
public class QueueImplemetationUsingArray {
    public static void main(String[] args) {
        QueueUsingArray qua = new QueueUsingArray();
        qua.enqueue(10);
        qua.enqueue(20);
        qua.print();
        
    }


}


 class QueueUsingArray{

    int[] arr;
    int front;
    int rear;
    int size;


    QueueUsingArray(){
        size = 1000001;
        arr = new int[size];
        front=0;
        rear =0;
    }

    void enqueue(int data){
        if(rear == size){
            System.out.println("Queue is full");
            return;
        }
        else{
            arr[rear++] = data;
        }
    }

    int dequeue(){
        int ans =-1;
        if(front == rear){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            ans = arr[front];
            arr[front] =-1;
            front++;
            if(front == rear){ // see reason in notes
                front =0;
                rear =0;
            }
        }
        return ans;
    }


    boolean isEmpty(){
        if(front == rear){
            return true;
        }else{
            return false;
        }
    }

    int front(){
        if(front == rear){
            return -1;
        }else{
            return arr[front];
        }
    }

    void print(){
        for(int x : arr){
            System.out.print(x + " ");
        }
    }


 }