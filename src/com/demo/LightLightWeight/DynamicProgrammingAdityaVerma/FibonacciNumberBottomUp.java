package com.demo.LightLightWeight.DynamicProgrammingAdityaVerma;

import java.util.Arrays;

//TC O(n) SC O(n) //better space than top down
public class FibonacciNumberBottomUp {
    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
    }


    static int findFib(int n, int[] dp){

        dp[0] = 0; // initally ye values toh rhengi hi
        dp[1] = 1;

        for(int i =2;i<=n;i++){ //loop chla diya 
            dp[i] = dp[i-1]+dp[i-2]; // jo recursive call tha usko hta diya 
        }
        return dp[n];
        }


        //Space Optimized Approach
        //TC O(n) //! SC O (1)
        static int findFibAppraochBetter(int n){
            int prev1 = 1;
            int prev2 = 0;

            for(int i=2;i<=n;i++){
                int curr = prev1+prev2; // ek answer nikl gya toh agli
                // call pe 2 aage jayega 3 pe aur 3 ke liye uske peeche wale elements bhi toh ek ek aage jayenge na 

                prev2 = prev1; // prev2 ko update kr diya
                prev1 = curr; //prev1 ko curr ke barabar kr diya
            }
            return prev1; // return kr diya prev1
        }
}
