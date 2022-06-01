package com.demo.RecursionAndBacktTracking.Recursion;

public class PalindromeNumber {
    public static void main(String[] args) {

        int n = 121;


        int rev=0;
        while (n > 0) {
            int r = n%10;
            rev = r+rev*10;
            n/=10;
        }
        System.out.println(rev);

    }


}
