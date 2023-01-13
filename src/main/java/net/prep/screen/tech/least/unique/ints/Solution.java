package net.prep.screen.tech.least.unique.ints;

import java.util.*;
class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> refCounts = accumulateRefCounts(arr);
        List<Integer> inverseRefCounts = invertRefCounts(refCounts);
        return calcMinUniq(inverseRefCounts, k);
    }

    private Map<Integer, Integer> accumulateRefCounts(int[] arr) {

        Map<Integer, Integer> result = new HashMap<>();

        for (int i : arr) {
            if (result.containsKey(i)) {
                result.put(i, result.get(i) + 1);
            } else {
                result.put(i, 1);
            }
        }

        return result;
    }

    private List<Integer> invertRefCounts(Map<Integer, Integer> refCounts) {

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> e : refCounts.entrySet()) {
            result.add(e.getValue());
        }

        return result;
    }

    private int calcMinUniq(List<Integer> inverseRefCounts, int k) {
        int result = 0;

        Collections.sort(inverseRefCounts);
        Iterator<Integer> it = inverseRefCounts.iterator();

        while (it.hasNext()) {
            Integer e = it.next();

            if (k == 0) {
                result++;
            } else if (k >= e) {
                k -= e;
            } else {
                k = 0;
                result++;
            }
        }

        return result;
    }
}