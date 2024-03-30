package ktw.advanced.section06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Prob01 {
    int answer, L, target;
    List<Integer> nums;
    boolean[] visited;
    boolean flag;
    public int solution(int n) {
        int tmp = n;
        target = n;
        flag = false;
        nums = new ArrayList<>();
        while (tmp > 0) {
            int res = tmp % 10;
            nums.add(res);
            tmp /= 10;
        }
        Collections.sort(nums);
        L = nums.size();
        visited = new boolean[L];
        DFS(0, 0);
        if (!flag) {
            return -1;
        }
        return answer;
    }

    private void DFS(int length, int number) {
        if (flag) {
            return;
        }

        if (length == L) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < L; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(length + 1, number * 10 + nums.get(i));
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Prob01 T = new Prob01();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}