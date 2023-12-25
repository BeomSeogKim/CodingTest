package leet.top_interview_150._01_array_string;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class _01_MergeSortedArray {

    /*
     * 시간 복잡도 : O(NlogN) N : m + n -> Arrays.sort 사용
     * 공간 복잡도 : O(1) -> 별다른 공간 복잡도 사용하지 않음.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int num : nums2){
            nums1[m++] = num;
        }
        Arrays.sort(nums1);
    }

    /*
     * 시간 복잡도 : O(N) N : m + n
     * 공간 복잡도 : O(m) -> nums1 만큼 copy 했으므로
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        // Make copy of the first m elements of nums1
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        // Read pointers for nums1Copy and nums2 respectively.
        int p1 = 0;
        int p2 = 0;
        for (int p = 0; p < m + n; p++) {
            if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
                nums1[p] = nums1Copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }

    /*
     * 뒷자리는 빈공간이기 때문에 큰 값부터 대입.
     * 시간 복잡도 : O(N) N : m + n
     * 공간 복잡도 : O(1)
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
    }
