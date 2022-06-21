package com.demo.basicDATASTRUCTURE.Queues;


//https://practice.geeksforgeeks.org/problems/circular-tour/1
public class CircularTourImp {
    public static void main(String[] args) {
        int[] petrol = {4,6,7,4};
        int[] distance ={6,5,3,5};
        int ans =tour(petrol, distance);
        System.out.println(ans);
    }

    static int tour(int petrol[], int distance[]){
        int n = petrol.length;
        int defecit =0; // jab balance negative ho jaaye
        int balance =0; // balance aage bdhne pe kiita bach rha
        int start=0; // start index 

        for(int i=0;i<n;i++){
            balance+= petrol[i] - distance[i]; 
            if(balance <0){ // agar balance negative means circle not complete
                defecit+=balance;
                start = i+1; // start = rear+1 ;; rear = i wala concept
                balance=0; // aage se start krna hai toh balance reset krna pdega
            }
        }

        if(defecit + balance >=0){ // agar bhaiya defecit aur balance tmhra positive hai mtlb circle complete
            return start;
        }
        else{
            return -1;
        }
    }
}
