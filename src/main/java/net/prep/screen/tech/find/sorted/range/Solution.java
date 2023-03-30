package net.prep.screen.tech.find.sorted.range;

class Solution {

    private static final int[] NOT_FOUND = new int[] {-1, -1};

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return NOT_FOUND;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return NOT_FOUND;
            }
        }

        var rangeStart = -1;
        var rangeEnd = -1;

        // start the search
        int initialIndex = binSearch(nums, 0, nums.length - 1, target);
        if (initialIndex < 0) {
            return NOT_FOUND;
        }

        rangeStart = initialIndex;
        rangeEnd = initialIndex;

        var index = findLowerBound(nums, 0, initialIndex - 1, target, rangeStart);
        if (index >= 0) {
            rangeStart = index;
        }

        index = findUpperBound(nums, initialIndex + 1, nums.length - 1, target, rangeEnd);
        if (index >= 0) {
            rangeEnd = index;
        }

        return new int[] { rangeStart, rangeEnd };
    }

    /**
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private int findLowerBound(int[] nums, int start, int end, int target, int priorIndex) {
        var index = binSearch(nums, start, end, target);

        if (index < 0) {
            return priorIndex;
        } else if (index > 0) {
            return findLowerBound(nums, start, index - 1, target, index);
        } else {
            return index;
        }
    }

    /**
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private int findUpperBound(int[] nums, int start, int end, int target, int priorIndex) {
        var index = binSearch(nums, start, end, target);

        if (index < 0) {
            return priorIndex;
        } else {
            if (index != end) {
                return findUpperBound(nums, index + 1, end, target, index);
            } else {
                return index;
            }
        }
    }

    /**
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private int binSearch(int[] nums, int start, int end, int target) {

        if (start > end) {
            return -1;
        } else if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        } else {
            // start < end
            var index = (start + end) / 2;
            var content = nums[index];

            if (target == content) {
                return index;
            } else if (target < content) {
                return binSearch(nums, start, index, target);
            } else {
                // content < target
                return binSearch(nums, index + 1, end, target);
            }
        }
    }
}