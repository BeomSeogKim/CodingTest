package ktw.basic.hashmap_treeset;

import java.util.*;

public class _05_K번째_큰_수 {

    public static void main(String[] args) {
        _05_K번째_큰_수 a05K번째큰수 = new _05_K번째_큰_수();

        Scanner kb=new Scanner(System.in);
        int size = kb.nextInt();
        int number = kb.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = kb.nextInt();
        }
        System.out.println(a05K번째큰수.solution(size, number, nums));
    }

    /*
    TreeSet => 중복을 제거해 주면서 정렬까지 해주는 자료구조.
    * TreeSet의 경우 기본은 오름 차순 => 만약 내림차순으로 해주고 싶다면 Collections.reverseOrder()를 추가하자.
    * TreeSet.size() => TreeSet의 크기를 반환
    * TreeSet.first() => 첫번째 값 반환
    * TreeSet.last() => 마지막 값 반환
     */
    private int solution(int size, int number, int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());   // 기본이 오름차순 이기 때문에, 내림차순을 위해서는 Collections.reverseOrder() 추가
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int l = j + 1; l < size; l++) {
                    set.add(nums[i] + nums[j] + nums[l]);
                }
            }
        }

        int cnt = 0;
//        System.out.println(set.size());
        set.remove(143);
//        System.out.println("first = " + set.first());
//        System.out.println("last = " + set.last());
        for (int x : set) {
            System.out.println(x);
            cnt++;
            if (cnt == number) {
                return x;
            }
        }
        return -1;
    }
}
