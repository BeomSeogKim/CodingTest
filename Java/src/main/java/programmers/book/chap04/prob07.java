package programmers.book.chap04;

/*
 * url : https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class prob07 {

    /*
     * 문제 풀이 흐름
     * 문자열의 모든 문자에 대해 반복
     * * A 문자가 공백 문자일 경우
     * * * 그대로 이어 붙이기
     * * * 다음 등장하는 알파벳은 대문자
     * * B 공백 문자가 아닌 경우
     * * * 대 소문자 변환해 이어 붙이기
     * * * 다음 등장하는 알파벳의 대*소문자는 현재 변환하는 문자와 반대
     * 구성한 문자열 반환
     */
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                // 공백 처리
                builder.append(c);
                toUpper = true;
            } else {
                // 알파벳 변환
                if (toUpper) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        prob07 prob07 = new prob07();
        System.out.println(prob07.solution("hello WoRLd"));

    }
}
