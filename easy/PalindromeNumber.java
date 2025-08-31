class Solution {
    public boolean isPalindrome(int x) {
        return isPalindromeInt(x);
        //return isPalindromeString(String.format("%d", x));
    }

    private boolean isPalindromeInt(int x) {
        if (x < 0) {
            return false;
        }

        int original = x;
        int newNum = 0;

        while (x > 0) {
            int rem = x % 10;
            newNum = newNum * 10 + rem;
            x = x / 10;
        }
        return newNum == original;
    }
    private boolean isPalindromeString(String x) {

        int leftWalker = 0;
        int rightWalker = x.length()-1;

        while(leftWalker < rightWalker) {
            Character leftCharacter = x.charAt(leftWalker);
            Character rightCharacter = x.charAt(rightWalker);

            if (leftCharacter != rightCharacter) {
                return false;
            }

            leftWalker++;
            rightWalker--;
        }
        return true;
    }
}