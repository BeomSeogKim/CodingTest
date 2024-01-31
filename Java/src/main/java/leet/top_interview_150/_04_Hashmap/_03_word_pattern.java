package leet.top_interview_150._04_Hashmap;

import java.util.HashMap;
import java.util.Map;
/*
 * https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
 */
public class _03_word_pattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap();
        String[] stringArray = s.split(" ");

        if(pattern.length() != stringArray.length){
            return false;
        }


        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if (!map.containsKey(c)){
                // 키가 존재 하지 않는데, word가 존재한다면 잘못된 문법
                if(map.containsValue(stringArray[i])){
                    return false;
                }
                map.put(c, stringArray[i]);
            } else{
                String answer = map.get(c);
                // 만약 키에 해당 하는 값과 다른 값이 할당되려고 한다면 잘못된 문법
                if (!answer.equals(stringArray[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
