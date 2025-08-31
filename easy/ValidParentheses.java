class Solution {
    public boolean isValid(String s) {
        Stack<Character> stackCheck = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stackCheck.push(c);
                continue;
            }
            if (stackCheck.size() == 0) {
                return false;
            }
            Character matching = stackCheck.pop();
            if (c.equals(')')) {
                if (!matching.equals('(')) {
                    return false;
                }
            } else if (c.equals(']')) {
                if (!matching.equals('[')) {
                    return false;
                }
            }else if (c.equals('}')) {
                if (!matching.equals('{')) {
                    return false;
                }
            }
        }
        return stackCheck.isEmpty();
    }
}