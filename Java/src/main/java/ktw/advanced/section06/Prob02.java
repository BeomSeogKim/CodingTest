package ktw.advanced.section06;

import java.util.*;

class Prob02 {
    int answer;
    int[][] arr;
    boolean[] visited;
    Stack<Integer> stack;
    public int solution(int[][] fight){
        answer = 0;
        arr = new int[8][8];
        visited = new boolean[8];
        stack = new Stack<>();
        // Initializing
        for (int[] info : fight) {
            int person1 = info[0];
            int person2 = info[1];
            arr[person1][person2] = 1;
            arr[person2][person1] = 1;
        }

        DFS(0);

        return answer;
    }

    public void DFS(int length) {
        if (length == 7) {
            answer++;
        } else {
            for (int i = 1; i < 8; i++) {
                if (!stack.isEmpty() && arr[stack.peek()][i] == 1) {
                    continue;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                    DFS(length + 1);
                    stack.pop();
                    visited[i] = false;
                }
            }
        }
    }



    public static void main(String[] args){
        Prob02 T = new Prob02();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
