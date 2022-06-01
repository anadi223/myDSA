package com.demo.RecursionAndBacktTracking.Recursion;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReverseArrayRecursion {
    public static void main(String[] args) {
        int[] a = {2, 5, 4, 6, 9};
        char[] ar = {'a','b','c','d','e'};
        reverse(a, 0, a.length - 1);
        for (int x : a) {
            System.out.println(x);
        }
    }

    static void reverse(int[] a, int l, int r) {

        if (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            reverse(a, l + 1, r - 1);
        }
    }
}

