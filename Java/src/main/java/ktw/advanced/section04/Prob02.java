package ktw.advanced.section04;

import java.util.*;

class Prob02 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Arrays.sort(nums);

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != 0){
                answer[index++] = nums[i];
                map.put(nums[i], map.get(nums[i]) - 1);
                map.put(nums[i] * 2, map.get(nums[i] * 2) - 1);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Prob02 T = new Prob02();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
