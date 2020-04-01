package leetcode;

/**
 * Challenge: There are two sorted arrays nums1 and nums2 of size M and N
 * respectively. Find the median of the two sorted arrays. 
 * Time-Complexity of Solution Provided: O(MxN)
 *  Space-Complexity of Solution Provided: O(MxN)
 */

public class MedianOfArrays {
    public static double median(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0, i = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] <= nums2[p2]) {
                mergedArray[i++] = nums1[p1++];
            } else {
                mergedArray[i++] = nums2[p2++];
            }
        }

        while (p1 < nums1.length) {
            mergedArray[i++] = nums1[p1++];
        }

        while (p2 < nums2.length) {
            mergedArray[i++] = nums2[p2++];
        }
        if (mergedArray.length % 2 == 0) {
            return (mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) - 1]) / 2;
        } else {
            return mergedArray[mergedArray.length / 2];
        }

    }
}
