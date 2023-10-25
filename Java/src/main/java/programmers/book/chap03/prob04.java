package programmers.book.chap03;

public class prob04 {
    private int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr = new int[arr1.length][arr2[0].length];
        // 행렬 곱셈
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // arr[i][j]값 구하기
                arr[i][j] = 0;
                for (int k = 0; k < arr[i].length; k++) {
                    arr[i][j] = arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        prob04 prob04 = new prob04();
        int[][] arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = new int[][]{{3, 3}, {3, 3}};
        prob04.solution(arr1, arr2);
    }
}
