package net.prep.screen.tech.min.time.difference;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {

    private final static int MINS_IN_A_DAY = 24 * 60;

    public int findMinDifference(List<String> timePoints) {

        if (timePoints.size() <= 1) {
            return 0;
        }

        List<Integer> elapsedMinutes = convertClockTimes(timePoints);
        Collections.sort(elapsedMinutes);
        return calcMinDifference(elapsedMinutes);
    }

    private List<Integer> convertClockTimes(List<String> timePoints) {

        List<Integer> result = new ArrayList<>();

        for (String timePoint : timePoints) {

            String[] hrsAndMins = timePoint.split(":");
            int hrs = Integer.parseInt(hrsAndMins[0]);
            int mins = Integer.parseInt(hrsAndMins[1]) + (hrs * 60);
            result.add(mins);
            result.add(mins + MINS_IN_A_DAY);
        }

        return result;
    }

    private int calcMinDifference(List<Integer> elapsedMinutes) {
        // The list is sorted in ascending order

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < elapsedMinutes.size(); i++) {
            int diff = elapsedMinutes.get(i) - elapsedMinutes.get(i-1);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}