class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // i, j, _, _, _, _, k
        // -3, -2, -1, 0, 1, 2, 3 
        //Step 0 - Check edge cases
        if (nums.length < 3) {
            throw new RuntimeException();
        }

        //Step 1 
        Set<List<Integer>> results = new HashSet<>(2); //Saves an allocation later if we assume that there is at least 1 answer. 

        //Step 2 - Sort the array so we can run two pointer
        Arrays.sort(nums);

        //Indexes 
        int i = 0; 
        int j = 1;
        int k = nums.length-1; 

        //Step 3 - Find the results
        // Exit condition -1*nums[i] = nums[j] + nums[k]
        //Check the outer 
        while (i < nums.length -2) {
            System.out.printf("i = %d, j = %d, k = %d\n", i, j, k);
            int target = nums[i] * -1;
            while (j < k) {
                int sumJAndK = nums[j] + nums[k];
                if (target == sumJAndK) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                //Short circut in case we know we won't find a solution. 
                if (nums[j] > target) {
                    break;
                }
                
                if (sumJAndK < target) {
                    j++;
                } else {
                    k--;
                }
            }
            i++;
            j = i +1;
            k = nums.length-1;
        }
        return new ArrayList<>(results); 
    }
}