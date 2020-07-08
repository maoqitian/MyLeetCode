/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {

        // 纵向对比 时间复杂度 O(n^2)

        if(strs == null || strs.length == 0) return "";
        
        //字符串个数
        int count = strs.length;
         
        //获取第一个与第二个对比
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i); 
            for (int j = 1; j < count; j++) {
                 //字符比较不相等直接返回比对相当等的区间
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
// @lc code=end

