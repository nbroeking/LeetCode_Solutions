class Solution {
    public int lengthOfLastWord(String inputS) {
        String[] strings = inputS.split(" ");
        return Arrays.stream(strings).filter(s -> {
            if (s.length() == 0) {
                return false;
            } else if (s.length() == 1) {
                return !s.equals(" ");
            } else {
                return true;
            }
        })
        .reduce((first, second) -> second)
        .map(last -> last.length())
        .orElseThrow();
    }
}