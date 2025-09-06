class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return ""; //Exception
        }
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            num = intToRomanAddNextToken(num, result);
        }
        return result.toString();
    }

    public int intToRomanAddNextToken(int num, StringBuilder roman) {
        if (num == 4) {
            //Subtractive Sequence
            roman.append("IV");
            return num - 4;
        } 
        
        if (num < 5) {
            roman.append("I");
            return num - 1;
        }
        
        if (num == 9) {
            // Subtractive sequence
            roman.append("IX");
            return num - 9; 
        } 
        
        if (num < 10) {
            roman.append("V");
            return num - 5;
        } 
        
        if (num < 40) {
            roman.append("X");
            return num -10;
        }
        
        if (num < 50) {
            // This is a subtractive sequence
            roman.append("XL");
            return num - 40;
        } 
        
        if (num < 90) {
            roman.append("L");
            return num - 50;
        } 
        
        if (num < 100) {
            //This is a subtractive sequence
            roman.append("XC");
            return num - 90;
        } 

        if (num < 400) {
            roman.append("C");
            return num - 100;

        } 

        if (num < 500) {
            //This is a subtractive sequence
            roman.append("CD");
            return num - 400;
        }

        if (num < 900) {
            roman.append("D");
            return num - 500;
        }
        
        if (num < 1000) {
            // This is a subtractive sequence
            roman.append("CM");
            return num - 900;
        }

        roman.append("M");
        return num - 1000;

    }
}