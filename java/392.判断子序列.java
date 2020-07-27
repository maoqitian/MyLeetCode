/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {

        //双指针 时间复杂度 O(n+m)

        // int n = s.length(),m = t.length();
        // //分别遍历两个字符串的index
        // int index1 = 0,index2 = 0;

        // while(index1 < n && index2<m){

        //     if(s.charAt(index1) == t.charAt(index2)){
        //         //移动字符串 n 的指针
        //         index1++;
        //     }
        //     //字符串的指针一直移动
        //     index2++;
        // }

        // //返回 index1 值是否等于字符串 s 的长度
        // return index1 == n;

        //动态规划
        //dp[i][j]表示字符串t的前j个字符串包含s的前i个字符串
        //s.charAt(i - 1) == t.charAt(j - 1)
        //dp[i][j] = dp[i - 1][j - 1]

        //s.charAt(i - 1) != t.charAt(j - 1)
        //dp[i][j] = dp[i][j - 1];

        boolean [][]dp = new boolean[s.length()+1][t.length()+1];

        //赋值
        for(int i =0;i<=t.length();i++){
           dp[0][i] = true;
        }

        for(int i =1;i<=s.length();i++){
            for(int j =1;j<=t.length();j++){
               if(s.charAt(i - 1) == t.charAt(j - 1)){
                dp[i][j] = dp[i - 1][j - 1];
               }else {
                dp[i][j] = dp[i][j - 1];
               }
             }
         }
        

         return dp[s.length()][t.length()];
        
    }
}
// @lc code=end

