package ktw.advanced.section02;

import java.util.*;
class Prob07 {

    class Time {
        private int hour;
        private int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

    }
    public String[] solution(String[] reports, int time){
        Map<String, Time> usage = new HashMap<>();
        Map<String, Integer> totalUsage = new HashMap<>();

        // Initializing
        for (String report : reports) {
            String[] infos = report.split(" ");
            String person = infos[0];
            String[] timeInfo = infos[1].split(":");
            int hour = Integer.parseInt(timeInfo[0]);
            int minute = Integer.parseInt(timeInfo[1]);
            String flag = infos[2];
            if (flag.equals("in")) {
                usage.put(person, new Time(hour, minute));
            } else {
                Time temp = usage.get(person);
                int total = (hour * 60 + minute) - (temp.getHour() * 60 + temp.getMinute());
                totalUsage.put(person, totalUsage.getOrDefault(person, 0) + total);
            }
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalUsage.entrySet()) {
            if (entry.getValue() > time) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
    }

    public static void main(String[] args){
        Prob07 T = new Prob07();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}