package programmers.book.chap04;

/*
 * url of prob : https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class prob12 {

    private static final String[] words = {
        "zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine"
    };

    /*
     * 각 인데스 값에 해당하는 영단어가 저장되어 있는 영단어 문자열 배열을 구성
     * 영단어 배열을 순회하며 입력 문자열에 등장하는 모든 영단어를 치환한 문자열 생성
     * 변환된 문자열을 정수로 변환한 후 반환
     */
    public int solution(String s) {
        for (int i = 0; i < words.length; i++) {
            s.replace(words[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
