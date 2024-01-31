package leet.top_interview_150._04_Hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
 */
public class _02_isomorphic_strings {
    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public boolean isIsomorphic(String s, String t) {
        return convertString(s).equals(convertString(t));
    }

    public String convertString(String s){
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c, i);
            }

            sb.append(map.get(c)).append(" ");
        }

        return sb.toString();
    }
}
