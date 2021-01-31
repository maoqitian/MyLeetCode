/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        //时间复杂度 O(n)
        int resLen = 0;

        for (int i = s.length()-1;i>=0;i--){
            if( s.charAt(i) != ' '){
                resLen ++;
            }else if (resLen != 0){
                return resLen;
            }
        }

        return resLen;

    }
}
// @lc code=end

