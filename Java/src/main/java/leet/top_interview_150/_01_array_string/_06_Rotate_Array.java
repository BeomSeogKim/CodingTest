package leet.top_interview_150._01_array_string;

/*
 * https://leetcode.com/problems/rotate-array/editorial/?envType=study-plan-v2&envId=top-interview-150
 */
public class _06_Rotate_Array {

    /*
     * 배열을 복사해 이동 시키는 방식
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(N)
     */
    public void rotate1(int[] nums, int k) {
        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            answer[(i + k) % nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = answer[i];
        }
    }

    /*
     * 순회 알고리즘 -> 처음 시작한 값이 될 때 까지 순회시키는 알고리즘
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;

        for(int start = 0; count < nums.length; start++){
            int current = start;
            int prev = nums[current];
            do{
                int next = (current + k ) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(start != current);
        }
    }


}
