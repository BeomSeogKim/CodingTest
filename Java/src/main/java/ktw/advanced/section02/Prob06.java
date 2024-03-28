package ktw.advanced.section02;

import java.util.*;

class Prob06 {
    class Info implements Comparable<Info>{
        private String time;
        private String name;

        public Info(String time, String name) {
            this.time = time;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Info o) {
            return this.time.compareTo(o.time);
        }
    }
    public String[] solution(String[] reports, String times){
        // < person : time >
        Map<String, String> map = new HashMap<>();
        for (String report : reports){
            String[] information = report.split(" ");
            String person = information[0];
            String time = information[1];
            map.put(person, time);
        }

        List<String> answer = new ArrayList<>();
        Queue<Info> queue = new PriorityQueue<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] timeInfo = times.split(" ");
            String begin = timeInfo[0];
            String end = timeInfo[1];
            String time = entry.getValue();
            if (time.compareTo(begin) >= 0 && time.compareTo(end) <= 0) {
                queue.offer(new Info(time, entry.getKey()));
//                answer.add(entry.getKey());
            }
        }
//        answer.sort(Comparator.comparing(map::get));

        while (!queue.isEmpty()) {
            answer.add(queue.poll().getName());
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args){
        Prob06 T = new Prob06();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}