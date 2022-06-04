package com.demo.basicDATASTRUCTURE.ArraysByLoveBabbar.TwoDArrays;
//https://leetcode.com/problems/rotate-image/discuss/2103472/Java-100-faster-solution
public class RotateBy90 {
    public static void main(String[] args) {
        
    }
    
    public static void rotate(int[][] matrix){
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int sRow = 0, sCol = 0; 
        for(int i=0;i<matrix.length;i++){
            int tempRow = i, tempCol = i;
            while(tempRow < rowSize){
                int temp = matrix[tempCol][sCol];
                matrix[tempCol][sCol] = matrix[sRow][tempCol];
                matrix[sRow][tempCol] = temp;
    
                tempRow++;
                tempCol++;
            }
            sRow++;
            sCol++;
        }
    
        sCol = 0;
        int eCol = colSize-1;
        while(sCol < eCol){
            for(int i=0;i<rowSize;i++){
                int temp = matrix[i][sCol];
                matrix[i][sCol] = matrix[i][eCol];
                matrix[i][eCol] = temp;
            }
            sCol++;
            eCol--;
        }
    }



    }
