package net.prep.screen.tech.extended.map;

import java.util.*;

public class Solution {

    long solution(String[] queryType, int[][] query) {

        long result = 0;
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < queryType.length; i++) {
            int[] qv = query[i];
            switch (queryType[i].toLowerCase()) {
                case "insert" -> handleInsert(qv, map);
                case "addtokey" ->  handleAddToKey(qv, map);
                case "addtovalue" -> handleAddToValue(qv, map);
                case "get" -> result += handleGet(qv, map);
                default -> {}
            }
        }

        return result;
    }

    private void handleInsert(int[] qv, Map<Integer, Integer> map) {
        map.put(qv[0], qv[1]);
    }

    private void handleAddToValue(int[] qv, Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer newValue = e.getValue() + qv[0];
            e.setValue(newValue);
        }
    }

    private void handleAddToKey(int[] qv, Map<Integer, Integer> map) {

        var shadowMap = new HashMap<Integer, Integer>();
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer oldKey = e.getKey();
            Integer value = (shadowMap.containsKey(oldKey)) ? shadowMap.get(oldKey) : e.getValue();
            Integer newKey = oldKey + qv[0];
            if (map.containsKey(newKey)) {
                shadowMap.put(newKey, map.get(newKey));
            }
            map.put(newKey, value);

            if (map.get(oldKey).equals(map.get(newKey))) {
                map.remove(oldKey);
            }
        }
    }

    private Integer handleGet(int[] qv, Map<Integer, Integer> map) {
        return map.get(qv[0]);
    }

}

