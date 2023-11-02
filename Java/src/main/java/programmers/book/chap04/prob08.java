package programmers.book.chap04;

import java.util.ArrayList;
import java.util.List;

/*
 * url of prob : https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class prob08 {
    /*
     * 문제 풀이 흐름
     * 1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복
     * 설정된 길이만큼 문자를 잘라낸 token의 배열 생성
     * 문자열을 비교하며 token의 배열을 하나의 문자열로 압축
     * 1 ~3 과정으로 압축된 문자열 중 가장 짧은 길이 반환
     */
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length < s.length(); length++) {
            // 문자열 압축 후 가장 짧은 길이 선택
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }
        return min;
    }

    private int compress(String source, int length) {
        // 압축한 문자열의 길이 반환
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            // 압축 문자열 구성
            if (token.equals(last)) {
                count++;
            } else {
                // 새로운 토큰 등장 처리
                if (count > 1) builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) builder.append(count);
        return builder.length();
    }

    private List<String> split(String source, int length) {
        ArrayList<String> tokens = new ArrayList<>();
        // source를 token 만큼 씩 잘라 token 리스트에 추가
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            // 문자열을 startIndex부터 잘라 token 리스트에 추가
            int endIndex = startIndex + length;
            if (endIndex > source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }
}
