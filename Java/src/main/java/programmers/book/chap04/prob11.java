package programmers.book.chap04;

/*
 * url of prob : https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class prob11 {

    /*
     * 문자열을 모두 소문자로 변환
     * "p"의 개수 세기
     * * 문자열에 등장하는 모든 "p"를 빈 문자열 ""로 치환
     * * 원본 문자열과 변환된 문자열의 길이 차이가 p의 개수
     * 앞선 방식으로 y의 개수 세기
     * p의 개수, y의 개수 비교
     */
    boolean solution(String s) {
        s = s.toLowerCase();

        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();

        return ps == ys;
    }

    /*
     * 보다 좀 더 효율적인 코드
     */
    boolean solution2(String s) {
        int ps = 0;
        int ys = 0;

        for (char c : s.toCharArray()) {
            switch (c){
                case 'p', 'P' -> ps++;
                case 'y', 'Y' -> ys++;
            }
        }

        return ps == ys;
    }


}
