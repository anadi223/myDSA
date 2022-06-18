package com.demo.StriverSDESheet.Arrays;
//https://www.codingninjas.com/codestudio/problems/893405?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Question6 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
       // int ans = stockBuyAndSellApproach1(arr);
       int ans = stockBuyAndSellApproach2(arr);
        System.out.println(ans);
    }
        

    //TC O(n square) SC O(1)
    static int stockBuyAndSellApproach1(int[] arr){
        int maxProfit=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    maxProfit = Math.max(arr[j] - arr[i],maxProfit); //compare karo ki agar dono ko minus karo aur maxProfit me store karo aur store krte time compare karo ki maxprofit me jo value hai wo is difference se choti toh nhi hai na
                }
            }
        }
        return maxProfit;
    }
        //TC O(N) SC O(1)
    static int stockBuyAndSellApproach2(int[] arr){
        int maxPro =0;
        int minPro = Integer.MAX_VALUE; // ek min ek max bna ko

        for(int i=0;i<arr.length;i++){
            if(minPro> arr[i]){ // check kro agar minPro jyada hai toh minPro ko update kro
                minPro = arr[i];
            }
            if(maxPro <(arr[i] -minPro)){ // same step max pro ko check kro ki arr[i] aur minPro ke difference se chota hai kya
                maxPro = arr[i]-minPro; //if yes maxPro ko update kr do
            }
        }
return maxPro;
    }

}
