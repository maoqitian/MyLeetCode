import java.util.*


//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 758 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {

        //单调栈 转化为 84 题解法 时间复杂度 O(mn) m n 为矩阵行列数
        if(matrix.isEmpty()) return 0

        //行列
        val col = matrix.size
        val row = matrix[0].size

        //记录每一行数组中 1 的个数
        val height = IntArray(row)

        var res = 0

        for(i in 0 until col){
           for (j in 0 until row ){
               if(matrix[i][j] == '1'){
                   height[j] += 1
               }else{
                   height[j] = 0
               }
           }
           res = Math.max(res,largeArea(height))
        }
        return res
    }

    private fun largeArea(height: IntArray): Int {
        //当前行 1 最大面积
        var res = 0
        //使用栈
        val stack = LinkedList<Int>()
        val newHeight = IntArray(height.size + 2)

        for (i in 1 until height.size+1){
            newHeight[i] = height[i-1]
        }
        //计算面积
        for (i in newHeight.indices){
            while (!stack.isEmpty() && newHeight[stack.last] > newHeight[i]){
                val cur = stack.removeLast()
                res = Math.max(res,(i-stack.last-1)*newHeight[cur])
            }
            stack.addLast(i)
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
