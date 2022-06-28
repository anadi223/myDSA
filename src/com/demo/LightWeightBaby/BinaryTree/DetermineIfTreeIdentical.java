package com.demo.LightWeightBaby.BinaryTree;


//https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
public class DetermineIfTreeIdentical {
    public static void main(String[] args) {
        
    }

    static boolean isIdenticalTree(Node root1, Node root2){
        if(root1 == null && root2 == null){ // dono null mtlb identical
            return true;
        }

        if(root1 == null && root2 != null){ // ek null ek me data kaise identical hoga
            return false;
        }
        
        if(root1 != null && root2 == null){
            return false;
        }

        boolean left = isIdenticalTree(root1.left, root2.left); // left subtree ki call 
        boolean right = isIdenticalTree(root1.right, root2.right); 

        boolean valueCheck = root1.data == root2.data; // dono left and right trees ka value bhi toh check hoga na

        if(left && right && valueCheck){
            return true;
        }else{
            return false;
        }

    }
}
