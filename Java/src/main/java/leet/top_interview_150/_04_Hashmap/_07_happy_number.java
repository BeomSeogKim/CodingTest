package leet.top_interview_150._04_Hashmap;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150
 */
public class _07_happy_number {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    public int getNext(int number){
        int total = 0;
        while(number > 0){
            int d = number % 10;
            number /= 10;
            total += (d * d);
        }
        return total;
    }
}
