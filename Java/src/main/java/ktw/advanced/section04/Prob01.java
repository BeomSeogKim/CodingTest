package ktw.advanced.section04;

import java.util.*;
class Prob01 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        int[][] infos = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int cnt = 0;
            while (num > 0) {
                cnt += (num % 2);
                num /= 2;
            }
            infos[i][0] = nums[i];
            infos[i][1] = cnt;
        }
        Arrays.sort(infos, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < infos.length; i++){
            answer[i] = infos[i][0];
        }
        return answer;
    }

    public static void main(String[] args){
        Prob01 T = new Prob01();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}