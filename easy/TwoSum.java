class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();

        //Loop through input to create an index of all values
        for(int index = 0; index < nums.length; index++) {
            Integer value = nums[index];
            twoSumMap.put(value, index);
        }
        // For each element in the input see if there is a key that adds up to the sum.
        // If there is then return the indexs of the two values 
        for (int i = 0; i < nums.length; i++) {
            Integer targetValue = target - nums[i];
            if ( twoSumMap.containsKey(targetValue)) {
                if (i == twoSumMap.get(targetValue)) {
                    continue;
                }
                return new int[]{i, twoSumMap.get(targetValue)};
            }
        }
        return new int[]{0,0}; //If we don't find the answer return 0,0
    }
}