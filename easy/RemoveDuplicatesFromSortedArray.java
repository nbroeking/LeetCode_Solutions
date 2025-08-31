class Solution {
    public int removeDuplicates(int[] nums) {
        //Base Cases
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        //Now run the dedup logic
        int uniqueCounter = 1;
        int index = 0;
        int forwardIndex = 1;

        while (forwardIndex < nums.length) {
            int currentVal = nums[index];
            int nextVal = nums[forwardIndex];

            if (currentVal != nextVal) {
                index++;
                uniqueCounter++;
                nums[index] = nextVal; // This does an inplace shift
                continue;
            }
            forwardIndex++;
        }
        return uniqueCounter;
    }
}