//给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。 
//
// 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 105 
// -109 <= matrix[i][j] <= 109 
// 
// Related Topics 数组 
// 👍 176 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {

        //相当于把 M*N矩阵 转变成 N*M 矩阵 , res[j][i] = matrix[i][j]
        //时间复杂度 O（mn）

        var m = matrix.size
        var n = matrix[0].size
        val res = Array(n) { IntArray(m) }

        for (i in 0 until m){
            for ( j in 0 until n){
                res[j][i] = matrix[i][j]
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
