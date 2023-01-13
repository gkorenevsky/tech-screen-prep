package net.prep.screen.tech.string.difference;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private final Map<Character, Integer> charCount = new HashMap<>();
    private char result;

    public char findTheDifference(String s, String t) {

        for (char tc : t.toCharArray()) {
            int count = 1;
            if (charCount.containsKey(tc)) {
                count = charCount.get(tc);
                count++;
            }

            charCount.put(tc, count);
        }

        for (char sc : s.toCharArray()) {
            if (charCount.containsKey(sc)) {
                int count = charCount.get(sc);
                count--;
                charCount.put(sc, count);
            }
        }

        for (Map.Entry<Character, Integer> me : charCount.entrySet()) {
            if (me.getValue() > 0) {
                result = me.getKey();
            }
        }

        return result;
    }
}

