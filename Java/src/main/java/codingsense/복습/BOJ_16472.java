package codingsense.복습;

import java.util.Scanner;

/*
 Not Solved...
 */
public class BOJ_16472 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sentence = sc.next();
        int max = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int count = 1;
            int wordCount = 1;
            char currentChar = sentence.charAt(i);
            for (int p2 = i + 1; p2 < sentence.length(); p2++) {
                char newChar = sentence.charAt(p2);
                if (newChar != currentChar) {
                    wordCount++;
                }
                if (wordCount > N) {
                    break;
                }
                count++;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
