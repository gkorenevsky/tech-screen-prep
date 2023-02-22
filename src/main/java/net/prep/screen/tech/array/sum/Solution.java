package net.prep.screen.tech.array.sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
    Note: this solution works for arrays with positive numbers, and mixed positive and negative numbers.
          It doesn't work for arrays with negative numbers only. One possible modification for the latter would
          be to use absolute values when storing sums and calculating complements.
     */

    int[] getSubArray(int[] a, int sum) {
        int[] result = new int[0];
        boolean cont = true;
        int[] pSums = new int[a.length];
        Map<Integer, Integer> pSumMap = new HashMap<>();

        if (a.length == 0) {
            return result;
        }

        // calculate partial sums
        for (int i = 0, pSum = 0; i < a.length && cont; i++) {
            // if current cell == sum
            if (a[i] == sum) {
                // return singleton array
                result = new int[]{a[i]};
                cont = false;
            } else {
                // calculate and save partial sum
                pSum += a[i];
                pSums[i] = pSum;
                // if partial sum == sum
                if (pSum == sum) {
                    // allocate space for subarray
                    result = new int[i + 1];
                    // copy contents to subarray
                    System.arraycopy(a, 0, result, 0, i + 1);
                    cont = false;
                } else {
                    // save partial sum and its corresponding offset
                    pSumMap.put(pSum, i);
                }
            }
        }

        if (!cont) {
            // found required sum
            return result;
        }

        for (int i = 0; i < a.length && cont; i++) {
            // ignore partial sums <= sum
            // (a partial sum cannot be equal to sum, since it would have been found already)
            if (pSums[i] > sum && pSumMap.containsKey(pSums[i] - sum)) {
                int j = pSumMap.get(pSums[i] - sum);
                // ensure start of sub-array precedes its end
                if (j < i) {
                    cont = false;
                    result = new int[i - j];
                    // copy contents to subarray
                    System.arraycopy(a, j+1, result, 0, i - j);
                }
            }
        }

        return result;
    }
}
