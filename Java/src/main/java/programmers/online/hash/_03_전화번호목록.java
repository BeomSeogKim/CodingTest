package programmers.online.hash;

import java.util.HashMap;
import java.util.Map;

/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42577
문제 설명 : 전화번호 목록이 담긴 phone_book이 주어질 때, 만약 어떤 전화번호가 다른 전화번호의 접두사일 경우 false return
 */
public class _03_전화번호목록 {

    /*
    시간 초과 난 solution
     * 시간 복잡도 : O(N ^ 2) => phone 길이만큼 map이 생성 되므로
     * 공간 복잡도 : O(N) => phone_book 길이 만큼
     */
    class Solution {
        public boolean solution(String[] phone_book) {
            Map<String, Boolean> map = new HashMap<>();
            // map에 전화번호 저장
            for(String phone : phone_book){
                map.put(phone, true);
            }

            // phone book 순회 조회
            for(String phone : phone_book){
                for(String key : map.keySet()){
                    if (phone.startsWith(key) && !phone.equals(key)){
                        return false;
                    }
                }
            }

            return true;
        }
    }

    /*
    시간 내에 들어오는 solution
     * 시간 복잡도 : O(N) => 전화번호의 길이는 최대 20자.
     * 공간 복잡도 : O(N) => phone_book의 길이만큼.
     */
    class Solution2 {
        public boolean solution(String[] phone_book) {
            Map<String, Boolean> map = new HashMap<>();
            // map에 전화번호 저장
            for(String phone : phone_book){
                map.put(phone, true);
            }

            for(String phone : phone_book){
                for(int i = 0; i < phone.length(); i++){
                    String substring = phone.substring(0, i);
                    if (map.containsKey(substring)){    // O(1)
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
