package com.demo.LightWeightBaby.BinaryTree.TreeTraversals;

//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
public class LCAOfTwoNodesImp {
    public static void main(String[] args) {
        
    }

    Node lca(Node root, int n1,int n2)
	{
	    if(root == null){
	        return null; // base case
	    }
	    if(root.data == n1 || root.data == n2){ // dudh rhe hm path me n1 ya n2 koi bhi traverse krte time
	        return root;
	    }
	    Node leftAns = lca(root.left,n1,n2); // left ans nikal ke lao
	    Node rightAns = lca(root.right,n1,n2); // right ans
	    
	    if(leftAns != null && rightAns!= null){ // agar left aur right dono null nhi aayua mtlb ans wali node pe ho tm
	        return root;
	    }else if( leftAns!= null && rightAns == null){ // if ek bhi not null hai toh not null wale ko paas kar do
	        return leftAns;
	    }else if(rightAns != null && leftAns == null){
	        return rightAns;
	    }else{ // ye wo case hai jab left aur right dono null hai toh simply null return karna hoga
	        return null;
	    }
	}
}
