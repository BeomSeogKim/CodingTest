package ktw.basic.hashmap;

import java.util.HashMap;
import java.util.Scanner;

/*

[ 설명 ]
학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.

투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.

선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.

반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.

[ 입력 ]
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.

두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.


[ 출력 ]

학급 회장으로 선택된 기호를 출력합니다.

 */
public class _01_학급회장 {

    /*
    배운 개념
    HashMap에서 제공하는 Method
    * getOrDefault(x, 0) : 키가 잆으면 값을 가져오고, 없다면 Default 값을 return
    * containsKey(key) :  map 이 키를 가지고 있는 지 확인하는 함수 => return값은 boolean
    * size() : HashMap의 key의 개수를 알려주는 함수
    * remove(key) : key 삭제 -> key에 해당하는 값을 return
     */
    public static void main(String[] args){
        _01_학급회장 a01학급회장 = new _01_학급회장();
        Scanner sc=new Scanner(System.in);
        int studentNumber = sc.nextInt();
        String vote = sc.next();
        System.out.println(a01학급회장.solution(studentNumber, vote));
    }

    /*
    시간 복잡도 : O(N) -> 투표 수만큼 for문을 돌아야 하기 때문에
    공간 복잡도 : O(k) -> k : HashMap의 키값.
     */
    private char solution(int studentNumber, String vote) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : vote.toCharArray()) {
            // getOrDefault(x,0) : 키가 있으면 값을 가져오고, 없다면 Default 값을 return
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    private char solution2(int studentNumber, String vote) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : vote.toCharArray()) {
            // getOrDefault(x,0) : 키가 있으면 값을 가져오고, 없다면 Default 값을 return
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // containsKey :  map 이 키를 가지고 있는 지 확인하는 함수
//        System.out.println(map.containsKey('F'));

        // size : key의 개수를 알려주는 함수
        System.out.println(map.size());

        // remove : key 삭제 -> key에 해당하는 값을 return 해준다.
        Integer removedValue = map.remove('A');

        System.out.println(map.size());
        return answer;
    }
}
