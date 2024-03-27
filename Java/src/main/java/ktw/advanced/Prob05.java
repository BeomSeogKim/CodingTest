package ktw.advanced;

import java.util.*;
class Prob05 {
    public String solution(String[] votes, int k){
        Map<String, List> voteMap = new HashMap<>();
        Map<String, Integer> giftMap = new HashMap<>();
        for (String info : votes) {
            String[] voteInfo = info.split(" ");
            String from = voteInfo[0];
            String to = voteInfo[1];
            // 투표 정보 저장.
            if (!voteMap.containsKey(to)) {
                List<String> list = new ArrayList<>();
                list.add(from);
                voteMap.put(to, list);
            } else {
                voteMap.get(to).add(from);
            }
        }

        voteMap.entrySet().forEach(e -> {
            List<String> fromList = e.getValue();
            if (fromList.size() >= k) {
                fromList.forEach(from -> {
                    giftMap.put(from, giftMap.getOrDefault(from, 0) + 1);
                });
            }
        });
        int max = 0;
        String answer = " ";
        for (Map.Entry<String, Integer> entry : giftMap.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                answer = entry.getKey();
            }
            if (max == entry.getValue()) {
                answer = answer.compareTo(entry.getKey()) <= 0 ? answer : entry.getKey();
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Prob05 T = new Prob05();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}