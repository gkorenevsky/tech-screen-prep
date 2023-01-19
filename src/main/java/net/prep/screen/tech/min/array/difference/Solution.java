package net.prep.screen.tech.min.array.difference;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    record ArrayElement(int value, int id) {}

    public int minArrayDifference(int[] first, int[] second) {

        if (first.length == 0 || second.length == 0) {
            throw new IllegalArgumentException("an empty argument was provided");
        }
        // trivial case
        if (first.length == 1 && second.length == 1) {
            return Math.abs(first[0] - second[0]);
        }

        List<ArrayElement> combinedValues = new ArrayList<>();

        Arrays.stream(first).forEach(v -> combinedValues.add(new ArrayElement(v,1)));
        Arrays.stream(second).forEach(v -> combinedValues.add(new ArrayElement(v,2)));

        // Sort elements in a combined array
        Collections.sort(combinedValues, (f, s) -> Integer.compare(f.value(), s.value()));
        int result = findMinDiff(combinedValues);

        return result;
    }

    private int findMinDiff(Collection<ArrayElement> entries) {

        int minDiff = Integer.MAX_VALUE;

        Iterator<ArrayElement> it = entries.iterator();
        ArrayElement prev = it.next();

        while (it.hasNext()) {
            ArrayElement next = it.next();
            if (prev.id() != next.id()) {
                minDiff = Math.min(minDiff, Math.abs(next.value() - prev.value()));
            }
            prev = next;
        }

        return minDiff;
    }
}
