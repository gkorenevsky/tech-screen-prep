package net.prep.screen.tech.array.sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
    Note: this solution works for arrays with only positive, only negative, and mixed positive and negative numbers.
     */

    int[] getSubArray(int[] a, int sum) {
        int[] result = new int[0];
        Map<Integer, Integer> pSumMap = new HashMap<>();
        boolean positive = false;

        if (a.length == 0) {
            return result;
        }

        // calculate partial sums
        for (int i = 0, pSum = 0; i < a.length; i++) {
            // if current cell == sum
            if (a[i] == sum) {
                // return singleton array
                result = new int[]{a[i]};
                break;
            } else {
                // indicate that a positive # is present
                positive |= (a[i] > 0);
                // calculate and save partial sum
                pSum += a[i];
                // if partial sum == sum
                if (pSum == sum) {
                    // allocate space for subarray
                    result = new int[i + 1];
                    // copy contents to subarray
                    System.arraycopy(a, 0, result, 0, i + 1);
                    break;
                } else {
                    // save current partial sum and its corresponding offset
                    pSumMap.put(pSum, i);

                    // if partial sum exceeds the target sum, check whether there is
                    // a prior partial sum which can be subtracted from the current one
                    // to yield the desired result.
                    if (pSumMap.containsKey(pSum - sum)) {
                        int j = pSumMap.get(pSum - sum);
                        result = new int[i - j];
                        // copy contents to subarray
                        System.arraycopy(a, j + 1, result, 0, i - j);
                        break;
                    }
                }
            }
        }

        return result;
    }
}
