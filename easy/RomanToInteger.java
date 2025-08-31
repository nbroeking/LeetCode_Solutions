class Solution {
    public int romanToInt(String s) {
        return process(s, 0);
    }

    private int process(String s, int currentIndex) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Character nc = getNextChar(s, i);
            int delta = convertTokenToInt(c, nc);
            sum += delta;
            // Need to account for two token increments
            if (delta == 4 || delta == 9 || delta == 40 || delta == 90 || delta == 400 || delta == 900) {
                i++;
            } 
        }
        return sum;
    }

    private Character getNextChar(String s, int currentIndex) {
        if (currentIndex >= s.length() - 1) {
            return '0';
        }
        return s.charAt(currentIndex +1);
    }
    private int convertTokenToInt(Character c, Character nc) {
        if (c.equals('I')) {
            if (nc.equals('V')) {
                return 4;
            }
            if (nc.equals('X')) {
                return 9;
            }
            return 1;
        }

        if (c.equals('X')) {
            if (nc.equals('L')) {
                return 40;
            }

            if ( nc.equals('C')) {
                return 90;
            }
            return 10;
        }

        if (c.equals('C')) {
            if (nc.equals('D')) {
                return 400;
            }
            if (nc.equals('M')) {
                return 900;
            }
            return 100;
        }

        if (c.equals('V')) {
            return 5;
        }
        if (c.equals('L')) {
            return 50;
        }
        if (c.equals('C')) {
            return 100;
        }
        if (c.equals('D')) {
            return 500;
        }
        if (c.equals('M')) {
            return 1000;
        }
        throw new RuntimeException("Invalid token");
    }
}