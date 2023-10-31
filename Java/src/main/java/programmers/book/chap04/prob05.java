package programmers.book.chap04;

/*
관련 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12932
 */
public class prob05 {

    /*
    문제 풀이 흐름
     * 입력받은 숫자를 문자열로 변환
     * 문자열을 뒤집음
     * 뒤집힌 문자열을 문자의 배열로 변환
     * 배열의 각 문자를 정수로 변환
     */
    public int[] solutiong(long n) {
        // 입력받은 숫자를 문자열로 변환
        String str = Long.toString(n);

        // 문자열을 뒤집는다 => StringBuilder를 사용
        String reversed = new StringBuilder(str).reverse().toString();

        // 뒤집힌 문자열을 문자의 배열로 변환
        char[] arr = reversed.toCharArray();

        // 배열의 각 문자를 정수로 변환
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }
        return result;
    }
    public static void main(String[] args) {
        prob05 prob05 = new prob05();
        int[] solutiong = prob05.solutiong(12345);
        for (int i : solutiong) {
            System.out.print(i + " ");
        }
    }
}
