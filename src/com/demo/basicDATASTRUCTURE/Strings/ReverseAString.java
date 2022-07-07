package com.demo.basicDATASTRUCTURE.Strings;

public class ReverseAString {
    public static void main(String[] args) {
        String str = "ANADI";
        int n = str.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(str.charAt(i));
        }

        sb.reverse();
        System.out.println(sb.toString());
}
}