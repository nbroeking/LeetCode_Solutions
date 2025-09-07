class Solution {
    public int removeElement(int[] nums, int val) {
        //First pass compute all the indexes that need to be "removed" and put them on a "queue"
        int numberOfMatches = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                numberOfMatches +=1; 
            }
        }

        // Step 2 swap the elements in place.  
        int leftPtr = 0;
        int rightPtr = nums.length -1;
        while (leftPtr < rightPtr) {
            if (nums[leftPtr] != val) {
                leftPtr++;
                continue;
            }

            if (nums[rightPtr] == val) {
                rightPtr--;
                continue;
            }

            //Perform a swap
            nums[leftPtr] = nums[rightPtr];
            nums[rightPtr] = val;
        }

        return nums.length - numberOfMatches;
    }
}