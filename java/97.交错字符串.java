/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        //动态规划
        //递推 题目的交错方式有讲究：交错从s1和s2拿元素，但每次可能拿多个
        //示例1 
        //s1: aa    bc     c
        //s2:    db    bca
        //如果s1的前i个字符和s2的前j个字符，能够交替拼出s3的前i+j个字符的话， 那么，s3的下一个字符随便从s1还是s2拿都是有可能的。



        //令f(i,j) 表示 s1 的前 i 个字符和 s2 的前 j 个字符能否交错组成 s3的前 i+j 个字符。

        // 递推关系： 令p = i+j-1, f(0,0)=true, 则f(i,j)有两种情况为真：
        // f(i-1,j) && s1[i-1]==s3[p]  || f(i,j-1) && s2[j-1]==s3[p]

        int n = s1.length(),m = s2.length(),t= s3.length();


        if(m+n != t)return false;

        boolean [][]dp = new boolean[n+1][m+1];

        //边界条件为 dp(0, 0) = True
        dp[0][0] = true;

        for (int i = 0; i <= n; ++i) {

            for (int j = 0; j <= m; ++j) {
                int p = i+j-1;
                if(i>0){
                  dp[i][j] = dp[i][j]||(dp[i-1][j]&& s1.charAt(i-1) == s3.charAt(p));
                }
                if(j > 0){
                    dp[i][j] = dp[i][j]||(dp[i][j-1]&& s2.charAt(j-1) == s3.charAt(p));
                }
            }
            
        }

        return dp[n][m];



    }
}
// @lc code=end

