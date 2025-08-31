class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] tokens = s.split(" ");
        if (pattern.length() != tokens.length) {
            return false;
        }
        return processTokens(pattern, tokens);
    }

    // Iterate the tokens to check that they match
    private boolean processTokens(String pattern, String[] tokens) {
        Map<Character, String> tokenMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String token = tokens[i];
            if (!tokenMap.containsKey(c)) {
                tokenMap.put(c, token);
            } else if (!tokenMap.get(c).equals(token)) {
                return false;
            }
        }

        //We have to also get the values into a value set
        Set<String> uniqueValues = new HashSet<>(tokenMap.values());
        return uniqueValues.size() == tokenMap.size();
    }
}