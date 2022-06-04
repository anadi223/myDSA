package com.demo.basicDATASTRUCTURE.Arrays;

import java.util.*;
//https://leetcode.com/problems/unique-number-of-occurrences/submissions/
public class UniqueOccurance {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,2,3,3,3,3};
        UniqueOccurance ur = new UniqueOccurance();
        boolean b = ur.uniqueOccurrences(arr);
        System.out.println(b);
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr) {
            int val = map.getOrDefault(i, 0);
            map.put(i, ++val);
        }

        List<Integer> list = new ArrayList<Integer>(map.values());
        Set<Integer> set = new HashSet(list);

        return list.size() == set.size();
    }

}
