package leet.frequency150;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/description/
 */
public class _01_TwoSum {
    // 값, index
    private Map<Integer, Integer> map = new HashMap<>();

    /*
     * 시간 복잡도 : O(N) -> nums 순회해야하기 때문에
     * 공간 복잡도 : O(N) -> nums 크기만큼 저장하기 때문에
     */
    public int[] solution1(int[] nums, int target) {
        int index = 0;
        for (int num : nums) {
            // map에 값이 있는지 체크
            int res = target - num;
            if (map.containsKey(res)) {
                return new int[]{map.get(res), index};
            }

            map.put(num, index++);
        }

        return null;
    }

    public int[] solution2(int[] nums, int target) {
        int index = 0;

        // Build HashTable
        for (int num : nums) {
            map.put(num, index++);
        }

        // Find the complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        return null;
    }
}
