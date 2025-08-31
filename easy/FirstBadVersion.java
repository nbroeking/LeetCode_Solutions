/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n < 1) {
            throw new RuntimeException("invalid input");
        }
        return binarySearchForBadVersion(1, n);
    }

    private int binarySearchForBadVersion(int min, int max) {
        int pivot = min + (max-min)/2;
        boolean isPivotBad = isBadVersion(pivot);
        boolean isPivotPlusOneBad = isBadVersion(pivot+1);

        if (!isPivotBad && isPivotPlusOneBad) {
            return pivot+1;
        }

        // This only works if we assume there always has to be a bad
        if (min == max) {
            return min;
        }

        //If mid is bad then we need to search left
        if (isPivotBad) {
            return binarySearchForBadVersion(min, pivot);
        }

        return binarySearchForBadVersion(pivot, max);
    }
}