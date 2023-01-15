package net.prep.screen.tech.isomorphic.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        if (s.compareToIgnoreCase(t) == 0) {
            return true;
        }

        Map<Character, Set<Integer>> sourceMap = countChars(s);
        Map<Character, Set<Integer>> targetMap = countChars(t);

        var result = checkStrings(s, sourceMap, t, targetMap);

        return result;
    }

    private Map<Character, Set<Integer>> countChars(String str) {

        Map<Character, Set<Integer>> result = new HashMap<>();
        char[] sa = str.toCharArray();
        Set<Integer> v = null;

        for (int i = 0; i < sa.length; i++) {
            if (!result.containsKey(sa[i])) {
                v = new HashSet<>();
            } else {
                v = result.get(sa[i]);
            }

            v.add(i);
            result.put(sa[i], v);
        }

        return result;
    }

    private boolean checkStrings(String s,
                                 Map<Character, Set<Integer>> sourceMap,
                                 String t,
                                 Map<Character, Set<Integer>> targetMap) {

        boolean result = true;
        // determine if both strings contain the same # of dups in the same positions
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        for (int i = 0; i < ta.length && result; i++) {
            var sc = sa[i];
            var tc = ta[i];

            var sPos = sourceMap.get(sc);
            var tPos = targetMap.get(tc);

            if (sPos.size() != tPos.size()) {
                result = false;
            } else if (!sPos.equals(tPos)) {
                result = false;
            }
        }

        return result;
    }
}