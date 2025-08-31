class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Filter out invalid cases
        if (strs == null || strs.length == 0) {
            return "";
        }
        //Start with the first index
        int commonPrefix = 0;
        
        // While loop to iterate through all the characters. I don't normally like while(true)
        // but I think the logic is simpler for this case. 
        while(true) {
            //Character we are going to test. Alternative would be to set it equals to Strs[0].charAt(commonPrefix);
            Character charToMatch = null;
            //Iterate through all strings and check to make sure the char matches. If it doesn't then return the substring. 
            for(String s : strs) {
                if(commonPrefix >= s.length()) {
                    return s.substring(0, commonPrefix);
                }
                Character currentChar = s.charAt(commonPrefix);
                if (charToMatch == null) {
                    charToMatch = currentChar;
                }
                if (!charToMatch.equals(currentChar)) {
                    return s.substring(0, commonPrefix);
                }
            }
            commonPrefix += 1;
        }
    }
}