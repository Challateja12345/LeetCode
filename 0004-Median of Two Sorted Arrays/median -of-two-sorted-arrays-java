class Solution {
    // Class variables to store the size of arrays and the arrays themselves.
    private int sizeNums1;
    private int sizeNums2;
    private int[] nums1;
    private int[] nums2;

    // Main function to find the median of two sorted arrays.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Initialize class variables with array sizes and the arrays themselves.
        sizeNums1 = nums1.length;
        sizeNums2 = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;

        // Median can be the average of the middle two values for even length combined arrays 
        // or the middle one for odd length combined arrays.
        int leftMedian = findKthElement(0, 0, (sizeNums1 + sizeNums2 + 1) / 2);
        int rightMedian = findKthElement(0, 0, (sizeNums1 + sizeNums2 + 2) / 2);

        // The median is the average of the two middle numbers for even-sized arrays.
        return (leftMedian + rightMedian) / 2.0;
    }

    // Helper function to find the k-th element.
    private int findKthElement(int startNums1, int startNums2, int k) {
        // Base cases for recursion.
        if (startNums1 >= sizeNums1) {
            return nums2[startNums2 + k - 1]; // Select k-th element from nums2
        }
        if (startNums2 >= sizeNums2) {
            return nums1[startNums1 + k - 1]; // Select k-th element from nums1
        }
        if (k == 1) {
            // If k is 1, then return the minimum of current starting elements.
            return Math.min(nums1[startNums1], nums2[startNums2]);
        }
      
        // Calculate the mid point to compare elements.
        int midIndex = k / 2;
        // Assign INT_MAX if the mid point is beyond the array bounds.
        int midValNums1 = startNums1 + midIndex - 1 < sizeNums1 ? nums1[startNums1 + midIndex - 1] : Integer.MAX_VALUE;
        int midValNums2 = startNums2 + midIndex - 1 < sizeNums2 ? nums2[startNums2 + midIndex - 1] : Integer.MAX_VALUE;

        // Discard half of the elements from the array which has smaller midValue.
        // Because those can never contain the k-th element.
        if (midValNums1 < midValNums2) {
            return findKthElement(startNums1 + midIndex, startNums2, k - midIndex);
        } else {
            return findKthElement(startNums1, startNums2 + midIndex, k - midIndex);
        }
    }
}
