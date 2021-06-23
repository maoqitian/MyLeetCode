//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法 
// 👍 706 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        //动态规划 时间复杂度 O(m*n) m n 为两个字符串长度
        //递推公式
        // dp[i][j] = d[i+1][j] + dp[i][j+1]
        var dp = Array(s.length+1){ BooleanArray(p.length+1)}

        //初始数组的值
        dp[s.length][p.length] = true

        //竖向 * 匹配
        for (i in p.length -1 downTo 0){
            if (p[i] != '*') break
            else dp[s.length][i] = true
        }
        //遍历
        for (i in s.length -1 downTo 0){
            for (j in p.length -1 downTo 0){
               if(s[i] == p[j] || p[j] == '?'){
                   dp[i][j] = dp[i+1][j+1]
               }else if(p[j] == '*'){
                   dp[i][j] = dp[i+1][j] || dp[i][j+1]
               }else{
                   dp[i][j] = false
               }
            }
        }
        return dp[0][0]
    }
}
//leetcode submit region end(Prohibit modification and deletion)
