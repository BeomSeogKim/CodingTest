package leet.top_interview_150._02_two_pointer;

/*
 * https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
 */
public class _04_Container_With_Most_Water {

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public int maxArea(int[] height) {
        int lt = 0, rt = height.length - 1;
        int max = 0;
        while(lt < rt){
            int width = rt - lt;
            max = Math.max(max, width * (Math.min(height[lt], height[rt])));
            if(height[lt] <= height[rt]){
                lt++;
            }else{
                rt--;
            }
        }

        return max;
    }
}
