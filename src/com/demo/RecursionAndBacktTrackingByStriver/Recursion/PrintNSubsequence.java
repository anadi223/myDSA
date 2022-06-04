package com.demo.RecursionAndBacktTracking.Recursion;

import java.util.ArrayList;
import java.util.List;


//Notes Print N subsquence
public class PrintNSubsequence {
    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<Integer>((List.of(3,1,2)));
        ArrayList<Integer> arr = new ArrayList<>(List.of(3,1,2));
        ArrayList<Integer> a = new ArrayList<>();
        sub(0,a,arr);

        String s = "ABC";
        char[] c = new char[s.length()];

        for(int i=0;i<c.length;i++){
            c[i] = s.charAt(i);
        }
        System.out.println(c);

        StringPattern(0,new ArrayList<>(),c);
    }

    static void sub(int i, List<Integer> a, List<Integer> arr){
        if(i >= arr.size()){
            System.out.println(a);
            return;
        }
        a.add(arr.get(i)); // adding for take
        sub(i+1,a,arr); // For take
        a.remove(arr.get(i)); // This removal is important as explained in notes basically for not take
         sub(i+1,a,arr); // For Not take

    }

    static void StringPattern(int i, List<Character> a,char[] ab){

        if(i>=ab.length){
            System.out.println(a);
            return;
        }

        a.add(ab[i]);
        StringPattern(i+1,a,ab);
        a.remove(a.size()-1);
        StringPattern(i+1,a,ab);

    }

}
