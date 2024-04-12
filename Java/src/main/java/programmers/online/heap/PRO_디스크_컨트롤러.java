package programmers.online.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PRO_디스크_컨트롤러 {
    class Solution {
        public int solution(int[][] jobs) {

            Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);

            // duration 적은 순서대로 정렬
            PriorityQueue<JOB> queue = new PriorityQueue<>((j1, j2) -> j1.getDuration() - j2.getDuration());

            int time = 0;
            int sum = 0;
            int idx = 0;
            int count = 0;

            while (count < jobs.length) {
                while (idx < jobs.length && jobs[idx][0] <= time) {
                    queue.add(new JOB(jobs[idx][0], jobs[idx][1]));
                    idx++;
                }

                if (queue.isEmpty()) {
                    time = jobs[idx][0];
                } else {
                    JOB job = queue.poll();
                    sum += time + job.getDuration() - job.getStart();
                    time += job.getDuration();
                    count++;
                }
            }
            return sum / jobs.length;
        }

        static class JOB {
            private int start;
            private int duration;

            public JOB(int start, int duration) {
                this.start = start;
                this.duration = duration;
            }

            public int getStart() {
                return start;
            }

            public int getDuration() {
                return duration;
            }
        }
    }
}
