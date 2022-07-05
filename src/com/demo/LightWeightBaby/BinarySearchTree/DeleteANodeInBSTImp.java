package com.demo.LightWeightBaby.BinarySearchTree;

public class DeleteANodeInBSTImp {
    public static void main(String[] args) {
        
    }

    //https://leetcode.com/problems/delete-node-in-a-bst/submissions/
    static Node deleteFromBST(Node root, int val){
        if(root == null){
            return root;
        }

        if(root.data == val){
            //0 child case
            if(root.left == null && root.right == null){
                return null; //delete kar diya last node
            } // mtlb koi child hi nhi hai

            //1 chlid case
             //left child or child ho
             //left 
             if(root.left != null && root.right == null){
                Node temp = root.left;
                return temp; // root ko delete krwa do delete automatic hota java me maine neeche wala wapis bhej diya 
             }
             //right 
             if(root.left == null && root.right != null){
                Node temp = root.right;
                return temp; // root ko delete krwa do delete automatic hota java me maine neeche wala wapis bhej diya 
             }

            //2 child case //!IMPORTANT CASE 
            if(root.left != null && root.right != null){
                //left me se max value nikal lo or right me se min value nikal lo
                //toh hm min value nikal lete
                int mini = minVal(root.right).data; // right me se minimum value nikalo 
                root.data = mini;  // root ke data ko replace kar do mini se
                root.right = deleteFromBST(root.right, mini); // jab minimum value delete krne jaoge toh left most element is the min value and that is 0 child case mtlb seedha null return ho jayeag simple
                return root;
            }

        }
        else if(root.data > val){
            root.left = deleteFromBST(root.left, val);
            return root;
        }else{
            root.right = deleteFromBST(root.right, val);
            return root;
        }
        return null;
    }

    static Node minVal(Node root){
        Node temp  = root;
        while(temp.left!=null){
            temp =temp.left;
        }
        return temp;
    }

}
