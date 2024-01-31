package leet.top_interview_150._04_Hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
 */
public class _04_valid_anagram {

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap();

        if(s.length() != t.length()) return false;


        // Initializing map by s
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decounting map by t
        for(char c : t.toCharArray()){
            if (!map.containsKey(c)){
                return false;
            } else {
                int number = map.get(c);
                if (number == 1){
                    map.remove(c);
                } else{
                    map.put(c, number - 1);
                }
            }
        }
        return true;
    }
}
