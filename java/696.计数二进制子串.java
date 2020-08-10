/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {

        //计算出现的次数

        int left = 0,right = s.length(),last = 0,res = 0;

        while(left< right){

            char curr = s.charAt(left);

            int count = 0;
            while(left< right && s.charAt(left) == curr){
                ++left;
                ++count;
            }

            res += Math.min(count,last);
            last = count;
        }

        return res;
    }
}
// @lc code=end

