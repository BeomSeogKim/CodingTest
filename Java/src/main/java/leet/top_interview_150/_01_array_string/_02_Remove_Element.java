package leet.top_interview_150._01_array_string;

/*
 * https://github.com/dev-team-study/algorithm-study/pull/38/files#diff-2b60ec55bb48ede635273af0d0b1e81abb01b4fea8fbb754f8acff668c7a2c8aR18
 */
public class _02_Remove_Element {

    /*
     * 해당 문제의 경우 in-place로 치환하기를 원함.
     * 두가지 Pointer를 두어 치환하는 방식으로 문제 진행
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(1)
     */
    public int removeElement(int[] nums, int val) {
        int reader = 0;
        int writer = 0;
        int n = nums.length;

        while(reader < n){
            if (nums[reader] == val){
                reader++;
            } else {
                nums[writer] = nums[reader];
                writer++;
                reader++;
            }
        }
        return writer;
    }
    /*
     * reader의 경우 아래와 같이 for문으로 증가시키는 방법도 존재한다.
     */
    public int removeElement2(int[] nums, int val) {
        int writer = 0;
        int n = nums.length;

        for (int reader = 0; reader < n; reader++) {
            if (nums[reader] != val){
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
    }
}
