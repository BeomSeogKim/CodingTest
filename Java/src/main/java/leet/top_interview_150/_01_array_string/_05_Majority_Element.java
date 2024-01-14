package leet.top_interview_150._01_array_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 */
public class _05_Majority_Element {

    /*
     * 시간 복잡도 : O(NlogN)
     * 공간 복잡도 : O(1)
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
     * 시간 복잡도 : O(N^2)
     * 공간 복잡도 : O(1)
     */
    public int bruteForce(int[] nums) {
        int majorityCount = nums.length / 2;

        for(int num : nums){
            int count = 0;
            for (int elem : nums){
                if (elem == num){
                    count++;
                }
            }
            if(count > majorityCount){
                return num;
            }
        }

        return -1;
    }

    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(N)
     */
    private Map<Integer,Integer> countNums(int[] nums){
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for(int num : nums){
            if(!counts.containsKey(num)){
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        return counts;
    }


    public int hashMapSolution(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;

        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()){
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }


}
