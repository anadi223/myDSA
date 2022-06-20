package com.demo.basicDATASTRUCTURE.Stacks;

import java.util.Stack;

//!!! PRE REQUISITE-- LARGEST AREA IN A HISTOGRAM

//https://practice.geeksforgeeks.org/problems/max-rectangle/1/
public class MaxAreaOfAMatrixHard {
    public static void main(String[] args) {
        int[][] M = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        int n = M.length;
        int m = M[0].length;
        int ans = maxAreaInBinary(M,n,m);
        System.out.println(ans);
    }
    //*MAIN FUNCTION */
    static int maxAreaInBinary(int[][] M , int n, int m){

        //compute area for first row
        int area = largestRectangleArea(M[0]); //largest area in a histogram sirf ek array paas kr rhe observe carefully arr[0] will be first column

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){

                //Update rows by adding previous row values
                if(M[i][j] !=0){ // jab building ka base 0 na ho
                    M[i][j] = M[i][j] + M[i-1][j];
                }
                else{
                    M[i][j] =0; // jab zero hoga toh bhai sahab kya hi kroge
                }
            }
            area = Math.max(area, largestRectangleArea(M[i])); // area har row ke liye dekho kaun sa max hai kaun sa nhi
        }
        return area;
    }


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
