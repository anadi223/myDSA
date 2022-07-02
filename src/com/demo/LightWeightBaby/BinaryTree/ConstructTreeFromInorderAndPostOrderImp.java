package com.demo.LightWeightBaby.BinaryTree;

import java.util.HashMap;

//&SIMILAR TO INORDER AND PRE ORDER ONE WITH SOME CHANGES
//https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1/
public class ConstructTreeFromInorderAndPostOrderImp {
    public static void main(String[] args) {
        
    }
    //With position agar call karoge toh TC IS o(N2) aur with map call karoge toh TC O(nlogn)
    static Node buildTree(int in[], int post[], int n){
        //root element ka index
        int[] postorderIndex = {n-1}; // kyuki hmko iska index retain karna hai is liye array ke form me bhej rhe and ///!POST ORDER KA ROOT LAST ELEMENT HOTA HAI
        Node ans = solve(in,post,postorderIndex,0,n-1,n); //0 -- inOrder ka start index // n-1 --> inorder ka ending index
        return ans;
    }

    static Node solve(int[] inorder,int[] post,int[] postorderIndex, int inOrderStartIndex, int inOrderEndIndex,int size){
        //base case
        if(postorderIndex.length <0 || inOrderStartIndex > inOrderEndIndex){ // postorder ka index <0 har call pe index update hoga aur maan lo array se hi bahar hogye toh,, is liye condition check kar rhe -- inorderstart aur end index ye ensure kr rha ki array se bahar na ho jaaye
            return null;
        }

        int element = post[postorderIndex[0]--]; //post order ka last element root hoga toh wo element nikal lo aur postorderindex ko decrease kar do do
        Node root = new Node(element); // us element ka use karke root bana lo
        int pos = findPosition(inorder,element,size); // position find kar rhe kyuki hmko inorder me traverse karna hai 
        
        root.right = solve(inorder, post,postorderIndex,pos+1, inOrderEndIndex, size); //*Right call phle kyuuu?? Because post order me last index se shuru kar rhe aur jab decrement hoga postorder index ka toh wo inorder ke right part me aa jayega  see notes*/
        root.left = solve(inorder, post,postorderIndex, inOrderStartIndex, pos-1, size); // jab left wala dekhte hai toh innorder me root position ke left wala dekhna rhta naa check notes
        
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
    //ye bassically har element ke index ko map karega jo kaam hm position find kr rhe baar baar wo ek baar me hi ho rha hai isse
    static void mapElements(int[] inorder, HashMap<Integer,Integer> map,int n){
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }
    }
}
