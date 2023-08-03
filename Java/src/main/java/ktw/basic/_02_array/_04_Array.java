package ktw.basic._02_array;

import java.util.ArrayList;
import java.util.Scanner;

public class _04_Array {

    public static void main(String[] args) {
        _04_Array a04Array = new _04_Array();
        Scanner kb = new Scanner(System.in);
        int number = kb.nextInt();
        for (int num : a04Array.solution(number)){
            System.out.print(num + " ");
        }
    }

    private ArrayList<Integer> solution(int number) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(1);
        for (int i = 2; i < number; i++) {
            int nextNum = answer.get(i - 2) + answer.get(i - 1);
            answer.add(nextNum);
        }
        return answer;
    }
}
