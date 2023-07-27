package ktw.basic._01_string;

import java.util.Scanner;

public class _03_String {

    public static void main(String[] args) {
        _03_String _03_String = new _03_String();
        Scanner kb = new Scanner(System.in);
        String word = kb.nextLine();
        System.out.println(_03_String.solution2(word));

    }

    /*
    split()
     */
    private String solution(String word) {
        int m = Integer.MIN_VALUE;
        String answer = "";
        String[] words = word.split(" ");
        for (String s : words) {
            if (s.length() > m) {
                m = s.length();
                answer = s;
            }
        }
        return answer;
    }

    /*
    indexOf : 해당 문자가 들어있는 index를 반환 => 만약 해당 문자가 존재하지 않는다면 -1 을 return
     */
    public String solution2(String word) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = word.indexOf(" ")) != -1) {
            String tmp = word.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            word = word.substring(pos + 1);
        }
        // 남아있는 단어가 제일 긴 단어일 경우 값을 치환
        if (word.length() > m) {
            answer = word;
        }
        return answer;
    }

}
