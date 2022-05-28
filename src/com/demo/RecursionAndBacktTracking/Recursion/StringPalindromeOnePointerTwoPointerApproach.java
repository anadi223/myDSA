package com.demo.RecursionAndBacktTracking.Recursion;

public class StringPalindromeOnePointerTwoPointerApproach {
    public static void main(String[] args) {

        String s1 = "MADAM";
        boolean OnePointerRes = OnePointer(s1,0);
        System.out.println(OnePointerRes);
        boolean TwoPointerRes = TwoPointer(s1,0,s1.length()-1);
        System.out.println(TwoPointerRes);
    }

    static boolean OnePointer(String s,int l){
        if(l>=s.length()/2){
            return true;
        }
        if(s.charAt(l) != s.charAt(s.length()-l-1))
            return false;
        return OnePointer(s,l+1);
    }

    //khud se kiya ❤️❤️
    static boolean TwoPointer(String s, int l, int r){
        if(l>=r){
            return true;
        }
        if(s.charAt(l) != s.charAt(r))
            return false;

        return TwoPointer(s,l+1,r-1);
    }

    }
