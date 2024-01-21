package leet.top_interview_150._02_two_pointer;

import java.util.*;

/*
 * https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class _05_3Sum {
    /*
     * Time Complexity :
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>(new ArrayList<>());
        for(int p1 = 0; p1 < nums.length; p1++){
            int p2 = p1 + 1;
            int p3 = nums.length - 1;
            while(p2 < p3){
                int sum = nums[p1] + nums[p2] + nums[p3];
                if(sum > 0){
                    p3--;
                } else if (sum < 0){
                    p2++;
                }else {
                    list.add(List.of(nums[p1], nums[p2], nums[p3]));
                    p2++;
                    p3--;
                }
            }
        }

        return list.stream().toList();
    }
}
