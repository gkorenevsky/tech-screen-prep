package net.prep.screen.tech.longest.palindrome;

import java.util.*;

class Solution {
    public int longestPalindrome(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> charCounts = countChars(s);
        List<Integer> counts = extractCounts(charCounts);

        // is  string consists entirely of identical characters, return its length
        if (counts.size() == 1) {
            return s.length();
        }

        Collections.sort(counts, Collections.reverseOrder());

        int palLength = 0;
        for (int nextLength : counts) {
            // if even # of (dup) chars so far, can add even or odd # of chars
            if ((palLength % 2) == 0) {
                palLength += nextLength;
            } else if ((nextLength % 2) == 0) {
                // an odd # of chars can be combined with even
                palLength += nextLength;
            } else if (nextLength > 1) {
                // else, if next count > 1, decrement by one, else continue;
                palLength += (nextLength - 1);
            }
        }

        return palLength;
    }

    private Map<Character, Integer> countChars(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        return charCounts;
    }

    private List<Integer> extractCounts(Map<Character, Integer> map) {
        return new ArrayList<Integer>(map.values());
    }

}