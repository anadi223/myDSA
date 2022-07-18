package com.demo.LightLightWeight.DynamicProgrammingAdityaVerma;

public class ZeroOneKnapSackTopDown {
    public static void main(String[] args) {
        int val[] = {1,2,3};
        int wt[] = {4,5,6};
        int W =3;
        int n=3;
        int ans = zeroOneKnapSackTopDown(wt, val, W, n);
        System.out.println(ans);
    }


    static int zeroOneKnapSackTopDown(int[] wt, int[] val, int W, int n){

        int[][] t = new int[n+1][W+1];
        //Initialization of 0th row and 0th col
        for(int i =0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0){
                    t[i][j] =0;    // ye basically 0th row 0th col ko 0 se fill kar dega why 0-- recursion me base case me 0 liye the 
                }
            }
        }

        for(int i=1;i<n+1;i++){  // choice diagram ka code
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]); 
                    //[  recusion wali condition ko convert
                    //-- val[n-1]+knapsack(wt,val,W-wt[n-1],n-1) -- >> val[i-1]+t[i-1][j-wt[i-1]]  n ki jgh i and W ki jgh j simple    ]
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W]; // last index matrix ka answer liye baitha hoga
    }
}
