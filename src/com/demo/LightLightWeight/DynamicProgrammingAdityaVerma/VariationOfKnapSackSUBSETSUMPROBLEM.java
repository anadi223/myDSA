package com.demo.LightLightWeight.DynamicProgrammingAdityaVerma;

public class VariationOfKnapSackSUBSETSUMPROBLEM {
    public static void main(String[] args) {
        
    }
    //https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
    static boolean checkSubsetSum(int[] arr, int sum,int n){
        boolean[][] t = new boolean[n+1][sum+1];

        //Initialization part
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i == 0){
                    t[i][j] = false; // row ko false bnao
                }
                if(j == 0){
                    t[i][j] = true; // column ko true 
                }
            }
        }


        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(arr[i-1] <=j){ 
                    t[i][j] = (t[i-1][j-arr[i-1]] || t[i-1][j]); //knapsack ka code compare karo value array of knapsack ko ignore aur wt array ko arr se replace aur W ko sum se replace ,, max ki jgh || (OR operator) kyuki hmko true false chahiye 
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum]; //last index jisme answer hoga
    } 
}
