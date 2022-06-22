package com.demo.RecursionAndBacktTrackingByStriver.Recursion;

import java.util.ArrayList;
import java.util.Collections;

//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

public class RatInAMazeProblem {
    public static void main(String[] args) {

        int[][] m = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        int n = m.length;
        ArrayList<String> ans = findPath(m, n);
        System.out.print(ans);
    }

    static ArrayList<String> findPath(int[][] m, int n){
        int srcx=0; //starting index is 0,0
        int srcy=0;
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 0){  //agar starting hi 0 hai toh rat khda nhi ho payega aur origin pe jab nhi kdha ho pa rha toh aage kya hi jayega
            return ans;
        }

        int[][] visited = new int[n][n]; // ek array jo btayega ki position pe ja skte ki nhi
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] =0;
            }
        }

        StringBuilder path  = new StringBuilder(); //ek combination store krwane ke liye

        solve(m,n,ans,srcx,srcy,visited,path); //recursive function

        Collections.reverse(ans); // sorted order me ans chahiye tha is liye
        return ans;
    }

    private static void solve(int[][] m, int n, ArrayList<String> ans, int x, int y, int[][] visited,
            StringBuilder path) {

                //base case
                if(x == n-1 && y == n-1){ // final posistion pe pahoch gye dost 
                    ans.add(path.toString()); // ans array me add kr do aur return ho jaao
                    return;
                }

                visited[x][y] = 1; // yhn tak aa gye mtlb ek index pe toh ho hi toh us index ko 1 
                //4 choices 
                //down,left,right,up --- 4 tarike honge aur un tareeko me x and y change hoga //*rest code is same for down left right up */
                //down
                int newx = x+1;
                int newy = y;
                if(isSafe(newx,newy,n,visited,m)){
                    path.append('D'); //agar condition satisfied then append the ans
                    solve(m, n, ans, newx, newy, visited, path); //recursive call aur possible case 
                    path.deleteCharAt(path.length()-1); // jab recursive call se bahar aaoge toh bhaiya jo character append kiya usko htana pdega na baaki logon ko nhi pta abhi tak kya hua
                }

                // left
                 newx = x;
                 newy = y-1;
                if(isSafe(newx,newy,n,visited,m)){
                    path.append('L');
                    solve(m, n, ans, newx, newy, visited, path);
                    path.deleteCharAt(path.length()-1);
                }

                //right
                newx = x;
                newy = y+1;
               if(isSafe(newx,newy,n,visited,m)){
                   path.append('R');
                   solve(m, n, ans, newx, newy, visited, path);
                   path.deleteCharAt(path.length()-1);
               }

                //up
                newx = x-1;
                newy = y;
               if(isSafe(newx,newy,n,visited,m)){
                   path.append('U');
                   solve(m, n, ans, newx, newy, visited, path);
                   path.deleteCharAt(path.length()-1);
               }
               
               visited[x][y] =0; // jab wapis function se jaoge toh next possible soln ke liye visited ko wapis 0 mark krna pdega

    }

    static boolean isSafe(int x, int y, int n, int[][] visited , int[][] m){ //ye btayega ki ja skte ki nhi aage
        if((x >=0 && x<n) && (y>=0 && y<n) && (visited[x][y] ==0) && (m[x][y] == 1)){ //conditions to check whether you can go to a next index or not
            return true;
        }
        else{
            return false;
        }
    }
    

}
