//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 898 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {

        //经典动态规划题目

        // 方法一：

        //动态规划  dp[i][j] 表示从点 (i, j)(i,j) 到底边的最小路径和
        //时间复杂度 O(n^2)  空间复杂度 O(n^2)
        //相邻结点：与(i, j) 点相邻的结点为 (i + 1, j) 和 (i + 1, j + 1)。
        //状态转移 dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]

       /* var len = triangle.size
        val dp = Array(len + 1) { IntArray(len + 1) }

        //自顶向上
        for (i in len-1 downTo 0){
            for (j in 0 .. i){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
            }
        }
        return dp[0][0]*/

        //方法二 优化
        //上面解法计算 dp[i][j]dp[i][j] 时，只用到了下一行的 dp[i + 1][j]dp[i+1][j] 和 dp[i + 1][j + 1]dp[i+1][j+1]。
        //因此 dp 数组不需要定义 N 行，只要定义 1 行也就是一位数组
        //状态转移 dp[j]=min(dp[j],dp[j+1])+triangle[i][j]
        //时间复杂度 O(n^2)  空间复杂度 O(n)

        var len = triangle.size
        val dp =  IntArray(len + 1)

        //自顶向上
        for (i in len-1 downTo 0){
            for (j in 0 .. i){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle[i][j]
            }
        }
        return dp[0]
    }
}
//leetcode submit region end(Prohibit modification and deletion)
