package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogramHard {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
    }
    //!TC O(n) SC O(n)
    public static int largestRectangleArea(int[] heights){
        int n =heights.length;
        int[] next = new int[n];
        next = nextSmallerElement(heights,n); // find next smaller element

        int[] prev = new int[n];
        prev = prevSmallerElement(heights,n); // find prev smaller element
 
         int area = Integer.MIN_VALUE; // ans store krwane ke liye

        for(int i=0;i<n;i++){
            int l = heights[i]; // length

            if(next[i] == -1){ // jab next maan lo -1 hua toh area negative aa jayega check notes
                next[i] =n;
            }

            int b = next[i] - prev[i] -1;

            int newArea = l*b;

            area= Math.max(area, newArea);
        }
        return area;
    }

    //element is code me values ke liye nahi index ke liye rkh rhe that is why it is slightly diff
    static int[] nextSmallerElement(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];

        for(int i =n-1;i>=0;i--){
            int curr = arr[i];

            while(s.peek() != -1 && arr[s.peek()] >= curr){ // s.peek() agar -1 hai toh null point kra dega while ke bahar
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

    static int[] prevSmallerElement(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];

        for(int i =0;i<n;i++){
            int curr = arr[i];

            while(s.peek() != -1 && arr[s.peek()] >= curr){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

}
