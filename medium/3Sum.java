class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Brute force solution. Iterate through the list with two pointers and check the sum of all values

        // If we enforce that number1Index < number2Index < number3Index we will avoid duplicates

        // Step 0: Validate inputs
        
        // Step 1: inialize the result list and helper variables
        List<List<Integer>> result = new ArrayList(); 
        int number1Index = 0;
        int number2Index = 1; 
        int number3Index = 2;

        // Step 2: Iterate through the lists checking each combination. 
        while(number3Index < nums.length) {
            while( number2Index < number3Index) {
                while (number1Index < number2Index) {
                    int num1 = nums[number1Index];
                    int num2 = nums[number2Index];
                    int num3 = nums[number3Index];

                    System.out.printf("New Check\n");
                    System.out.printf("i1: %d, i2: %d, i3: %d\n", number1Index, number2Index, number3Index);
                    System.out.printf("n1: %d, n2: %d, n3: %d\n\n", num1, num2, num3);
                    //Check if we found a solution
                    if (num1 + num2 + num3 == 0) {
                        //We found a solution add it to the result;
                        result.add(Arrays.asList(num1, num2, num3));
                    }
                    number1Index++;
                }
                number1Index = 0;
                number2Index++;
            }
            number1Index = 0; 
            number2Index = 1;
            number3Index++;
        }
    
        //Step3: Return the result
        return result;
    }
}