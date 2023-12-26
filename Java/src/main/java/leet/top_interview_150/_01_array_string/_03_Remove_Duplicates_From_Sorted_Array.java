package leet.top_interview_150._01_array_string;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class _03_Remove_Duplicates_From_Sorted_Array {

    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(1)
     */
    public int removeDuplicates(int[] nums) {
        int reader = 1;
        int writer = 1;
        int n = nums.length;

        while(reader < n){
            if (nums[reader - 1] == nums[reader]){
                reader++;
            } else{
                nums[writer] = nums[reader];
                writer++;
                reader++;
            }
        }
        return writer;
    }

}
