package leet.top_interview_150._04_Hashmap;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
 */
public class Ransom_Note {

    /*
     * 해당 솔루션의 경우 HashMap을 사용해 magazine의 철자마다 카운트를 세어놓고, ransomNote의 철자를 비교하는 방식
     * 시간 복잡도 ; O(N)
     * 공간 복잡도 : O(N)
     */
    // true : magazine의 letter로 ransomNote를 작성할 수 있을 경우
    public boolean canConstruct(String ransomNote, String magazine) {
        // Initiate hashMap for magazine
        HashMap<Character, Integer> hashMap = new HashMap();
        for(char c : magazine.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c, 0) + 1);
        }

        for(char c : ransomNote.toCharArray()){
            if(!hashMap.containsKey(c)){
                return false;
            }
            if(hashMap.get(c) == 0){
                return false;
            }
            hashMap.put(c, hashMap.get(c) - 1);
        }

        return true;
    }

    /*
     * 해당 솔루션의 경우 별다른 공간을 사용하지 않고, String 의 메소드를 사용해서 해결 할 수 있다.
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(1)
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        for(char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c);

            if (index == -1){
                return false;
            }

            magazine = magazine.substring(0, index) + magazine.substring(index + 1);
        }
        return true;
    }
}
