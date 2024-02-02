package leet.top_interview_150._05_sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
 */
public class _02_longest_substring_without_repeating_characters {
    /*
     * Time Complexity : O(N * 2) => i 와 j 각각 전부 탐색
     * Space Complexity : O(min(m,n))
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0, end = 0, maxLength = 0;

        while(end < s.length()){
            char c1 = s.charAt(end);
            map.put(c1, map.getOrDefault(c1, 0) + 1);

            while(map.get(c1) > 1){
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);

            end++;
        }
        return maxLength;
    }
}
