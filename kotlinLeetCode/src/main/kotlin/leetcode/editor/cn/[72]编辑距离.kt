//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1734 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minDistance(word1: String, word2: String): Int {

        //动态规划 时间复杂度 O(mn) m n 为字符串的长度
        var n = word1.length
        var m = word2.length
        //如果有一个字符串为零
        if(n*m == 0 ) return n+m

        //动态规划路径数组
        val dp = Array(n+1){IntArray(m+1)}
        //初始化边界路径
        for (i in 0 until n+1) dp[i][0] = i
        for (j in 0 until m+1) dp[0][j] = j

        //计算路径上 dp 值

        for (i in 1 until n+1){
            for (j in 1 until m+1){
               var left = dp[i-1][j] + 1
               var down = dp[i][j-1]+1
               var leftDown = dp[i-1][j-1]
                if(word1[i-1] != word2[j-1]){
                    leftDown +=1
                }
                dp[i][j] = Math.min(left,Math.min(down,leftDown))
            }
        }
        return dp[n][m]
    }
}
//leetcode submit region end(Prohibit modification and deletion)
