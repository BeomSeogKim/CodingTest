package leet.top_interview_150._01_array_string;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class _04_Remove_Duplicates_From_Sorted_Array_2 {
    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(1)
     */
    public int removeDuplicates(int[] nums) {
        int writer = 1;
        int count = 1;

        for(int reader = 1; reader < nums.length; reader++){
            if (nums[reader] == nums[reader -1]){
                count++;
            } else {
                count = 1;
            }

            if (count <= 2){
                nums[writer++] = nums[reader];
            }
        }
        return writer;
    }
}
