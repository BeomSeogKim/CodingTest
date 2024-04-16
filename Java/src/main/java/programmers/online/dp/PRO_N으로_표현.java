package programmers.online.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PRO_N으로_표현 {
    class Solution {
        public int solution(int N, int number) {
            if(N == number){
                return 1;
            }

            List<Set<Integer>> list = new ArrayList<>();
            for(int i = 0; i <= 8; i++){
                list.add(new HashSet<>());
            }
            list.get(1).add(N);

            for(int i = 2; i <= 8; i++){
                StringBuilder sb = new StringBuilder().append(N);
                for(int j = 1; j < i; j++){
                    sb.append(N);
                }
                list.get(i).add(Integer.parseInt(sb.toString()));

                for(int j = 1; j < i; j++){
                    int k = i - j;
                    for(int num1 : list.get(j)){
                        for(int num2 : list.get(k)){
                            list.get(i).add(num1 + num2);
                            list.get(i).add(num1 - num2);
                            list.get(i).add(num1 * num2);
                            if(num2 != 0){
                                list.get(i).add(num1 / num2);
                            }
                        }
                    }
                }

                if(list.get(i).contains(number)){
                    return i;
                }
            }

            return -1;
        }
    }
}
