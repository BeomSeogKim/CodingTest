package leet.top_interview_150._02_two_pointer;

/*
 * https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
 */
public class _01_Valid_Palindrome {

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
