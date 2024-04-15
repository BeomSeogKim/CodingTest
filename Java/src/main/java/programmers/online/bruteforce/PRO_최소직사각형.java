package programmers.online.bruteforce;

public class PRO_최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int mx = 0;
            int mn = 0;
            // 모든 rows 돌기
            for(int i=0; i < sizes.length; i++){
                // 행의 크기 비교
                int max_t = Math.max(sizes[i][0], sizes[i][1]);
                int min_t = Math.min(sizes[i][0], sizes[i][1]);
                mx = Math.max(max_t, mx);
                mn = Math.max(min_t, mn);
            }
            return mx * mn;

        }
    }
}
