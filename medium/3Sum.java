class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Brute force solution. Iterate through the list with two pointers and check the sum of all values

        // If we enforce that number1Index < number2Index < number3Index we will avoid duplicates

        // Step 0: Validate inputs
        
        // Step 1: inialize the result list and helper variables
        Set<FoundSet> result = new HashSet<>(); 
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
                    
                    //Check if we found a solution
                    if (num1 + num2 + num3 == 0) {
                        //We found a solution add it to the result;
                        result.add(new FoundSet(num1, num2, num3));
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
        return result.stream().map(fs -> fs.toList()).collect(Collectors.toList());
    }

    //Found set represents a distinct set of 3 numbers that match the 3 sum match 
    public static class FoundSet {
        List<Integer> numbers = null;

        public FoundSet(int num1, int num2, int num3) {
            numbers = Arrays.asList(num1, num2, num3);
            Collections.sort(this.numbers);
        }

        public List<Integer> toList() {
            return numbers;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (!(obj instanceof FoundSet)){
                return false;
            }

            FoundSet fs = (FoundSet) obj;
            return this.numbers.equals(fs.numbers);
        }

        @Override
        public int hashCode() {
            return numbers.hashCode();
        }
    }
}