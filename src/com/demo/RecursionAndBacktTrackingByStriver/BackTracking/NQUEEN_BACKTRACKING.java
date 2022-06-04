package com.demo.RecursionAndBacktTrackingByStriver.BackTracking;

public class NQUEEN_BACKTRACKING {
    public static void main(String[] args) {

    }

    public static boolean nQueen(){return false;};
    public static boolean isSafe(int row,int col,int[][] b){
        // for upper-vertical
        for(int i=row;i>=0;i--){
            if(b[i][col]==1) {
                return false;
            }
        }

        // for upper-left diagonal
        int j=col;
        for(int i=row;i>=0 && j>=0;i--,j--){
            if(b[i][j]==1) {
                return false;
            }
        }

        // for upper-right diagonal
        j=col;
        for(int i=row;i>=0 && j<b.length;i--,j++){
            if(b[i][j]==1)
                return false;
        }

        return true;
    }
}
