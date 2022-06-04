package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar;
//https://www.codingninjas.com/codestudio/problems/duplicate-in-array_893397?source=youtube&campaign=love_babbar_codestudio1&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_codestudio1&leftPanelTab=1
import java.util.ArrayList;
import java.util.List;

public class DuplicateElements {
    public static void main(String[] args) {


    int[] arr= {5,1,2,3,4,2};
    ArrayList<Integer > ar2 = new ArrayList<>(List.of(5,1,2,3,2,1));

    int ans=0;
    int element=-1;
    for(int i=0;i<arr.length;i++){
        ans = ans^arr[i];
        if(ans == 0){
            element=arr[i]; }
    }
        System.out.println(ans);
        System.out.println(element);
}
}
