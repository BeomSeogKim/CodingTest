package leet.top_interview_150._02_two_pointer;

/*
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
 */
public class _02_Is_Subsequence {

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public boolean isSubsequence(String s, String t) {
        int leftBound = s.length(), rightBound = t.length();
        int pLeft = 0, pRight = 0;

        while(pLeft < leftBound && pRight < rightBound){
            if (s.charAt(pLeft) == t.charAt(pRight)){
                pLeft++;
            }
            pRight++;
        }

        return pLeft == leftBound;
    }
}
