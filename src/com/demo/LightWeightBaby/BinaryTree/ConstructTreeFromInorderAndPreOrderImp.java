package com.demo.LightWeightBaby.BinaryTree;


//https://practice.geeksforgeeks.org/problems/construct-tree-1/1/
public class ConstructTreeFromInorderAndPreOrderImp {
    public static void main(String[] args) {
        
    }

    static Node buildTree(int inorder[], int preorder[], int n){
        //root element ka index
        int[] preorderIndex = {0}; // kyuki hmko iska index retain karna hai is liye array ke form me bhej rhe
        Node ans = solve(inorder,preorder,preorderIndex,0,n-1,n); //0 -- inOrder ka start index // n-1 --> inorder ka ending index
        return ans;
    }

    static Node solve(int[] inorder,int[] preorder,int[] preorderIndex, int inOrderStartIndex, int inOrderEndIndex,int size){
        //base case
        if(preorderIndex.length >=size || inOrderStartIndex > inOrderEndIndex){ // preorderindex >=size har call pe index update hoga aur maan lo array se hi bahar hogye toh,, is liye condition check kar rhe -- inorderstart aur end index ye ensure kr rha ki array se bahar na ho jaaye
            return null;
        }

        int element = preorder[preorderIndex[0]++]; //pre order ka phla element root hoga toh wo element nikal lo aur preorderindex ko bdha do
        Node root = new Node(element); // us element ka use karke root bana lo
        int pos = findPosition(inorder,element,size); // position find kar rhe kyuki hmko inorder me traverse karna hai 
        
        root.left = solve(inorder, preorder,preorderIndex, inOrderStartIndex, pos-1, size); // jab left wala dekhte hai toh innorder me root position ke left wala dekhna rhta naa check notes
        root.right = solve(inorder, preorder,preorderIndex,pos+1, inOrderEndIndex, size); //similar for right one

        return root;
    }

    static int findPosition(int[] inorder, int element,int n){
        for(int i=0;i<n;i++){
            if(inorder[i] == element){
                return i;
            }
        }
        return -1;
    }
}
