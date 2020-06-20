/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        //动态规划，可能还是有点迷惑 时间复杂度 O(m*n) m和n 为两个字符串长度
        if(s == null || p == null) return false;

        int m = s.length();
        int n = p.length();
        //记录是否匹配的数组
        boolean [][] dp = new boolean[m+1][n+1];

        //初始空字符串代表能够匹配
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '*' && dp[0][i-1]){
               dp[0][i+1] = true;
            }
        }

        //双循环进行匹配
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '.'){
                  dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == s.charAt(i)){
                  dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                  if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                    dp[i+1][j+1] = dp[i+1][j-1];
                  }else{
                      dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]); 
                  }
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

