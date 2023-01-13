package net.prep.screen.tech.pivot.index;
class Solution {
    public int pivotIndex(int[] nums) {

        int fullSum = accumSum(nums);
        return findPivot(nums, fullSum);
    }

    private int accumSum(int[] nums) {

        int fullSum = 0;
        for (int i = 0; i < nums.length; i++) {
            fullSum += nums[i];
        }

        return fullSum;
    }

    private int findPivot(int[] nums, int fullSum) {
        int result = -1;
        int leftSum = 0;

        for (int i = 0; i < nums.length && result == -1; i++) {
            if (leftSum == fullSum - leftSum - nums[i]) {
                result = i;
            } else {
                leftSum += nums[i];
            }
        }

        return result;
    }
}

