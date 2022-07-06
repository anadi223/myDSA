package com.demo.LightWeightBaby.BinarySearchTree;

public class LCAofBST {
    public static void main(String[] args) {
        
    }
    //https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1/
    static Node LCAINBST(Node root, Node p, Node  q){
        if(root == null){
            return null;
        }

        if(root.data < p.data && root.data < q.data){ // agar root chota hai left and right se toh right call karo kyu root chota hai mtlb usse bada element right subtree me hoga na
            return LCAINBST(root.right, p, q);
        }
        
        if(root.data > p.data && root.data > q.data){ // agar root bda hai toh usse chota element left subtree me hoga na
            return LCAINBST(root.left, p, q);
        }

        return root; // Ye case hai jab root.data > p && root.data < q or or root.data < p && root.data > q //! in simple terms jab right left call se wapis aaoge toh dost tm usi node pe hoge jo LCA HAI
    }

    static Node LcaInBSTITerative(Node root, Node p, Node q){
        if(root == null){
            return null;
        }

        while(root !=null){
            if(root.data < p.data && root.data < q.data){ // agar root chota hai left and right se toh right call karo kyu root chota hai mtlb usse bada element right subtree me hoga na
                root= root.left;
            }
            
            else if(root.data > p.data && root.data > q.data){ // agar root bda hai toh usse chota element left subtree me hoga na
                root= root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
}
