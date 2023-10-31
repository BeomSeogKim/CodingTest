package programmers.book.chap04;

/*
관련 문제 URL : https://programmers.co.kr/learn/courses/30/lessons/12926
 */
public class prob06 {

    /*
     * 문제 풀이 흐름
     * 입력 문자열의 모든 문자에 대해 반복
     * * A. 알파벳이 아닌 경우 문자를 그대로 이어 붙이기
     * * 알파벳인 경우 n만큼 일어 이어 붙이기
     */
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            // c를 n만큼 민 문자를 builder에 이어 붙이기
            builder.append(push(c, n));
        }
        return builder.toString();
    }

    private char push(char c, int n) {
        // A
        if (!Character.isAlphabetic(c)) return c;

        // B c를 n만큼 밀어 반환
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char) (offset + position);
    }

    public static void main(String[] args) {
        prob06 prob06 = new prob06();

        System.out.println(prob06.solution("A B C", 2));
    }
}
