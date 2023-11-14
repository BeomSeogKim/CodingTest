package programmers.book.chap04;

/*
 * url of prob : https://programmers.co.kr/learn/courses/30/lessons/72410
 */
public class prob14 {

    public String solution(String newId) {
        // 1단계 : 모든 대문자를 대응되는 소문자로 치환.
        newId = newId.toLowerCase();
        // 2단계 : 알파벳 소문자, 숫자ㅡ, 빼기(-), 밑줄(_), 마침표(.) 만 사용가능.
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        // 3단계 : 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환.
        newId = newId.replaceAll("\\.+", ".");
        // 4단계 : 마침표가 처음이나 끝에 위치한다면 제거.
        newId = newId.replaceAll("(^\\.+)|(\\.+$)", "");
        // 5단계 : 빈 문자열이라면 "a" 대입
        if (newId.isEmpty()) newId = "a";
        // 6단계 : 16자 이상이라면 첫 15개의 문자를 제외한 나머지 제거.
        // 만약 제거 후 . 가 끝에 위치한다면 . 제거
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("\\.+$", "");
        }
        // 7단계 : 만약 길이가 2자 이하라면 마지막 문자를 3이 될 때 까지 이어 붙이기
        while (newId.length() < 3) {
            newId += newId.charAt(newId.length() - 1);
        }
        return newId;
    }
}
