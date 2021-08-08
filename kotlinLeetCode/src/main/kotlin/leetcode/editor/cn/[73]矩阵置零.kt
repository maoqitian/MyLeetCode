//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 数组 哈希表 矩阵 
// 👍 527 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {

        //用两个标记数组分别记录每一行和每一列是否有零出现。
        //具体地，我们首先遍历该数组一次，如果某个元素为 0，
        // 那么就将该元素所在的行和列所对应标记数组的位置置为 true
        // 最后我们再次遍历该数组，用标记数组更新原数组即可
        //参考 leetcode 官方题解
        //时间复杂度 O(mn)

        val m = matrix.size
        val n = matrix[0].size

        //行列标记数组

        val row = BooleanArray(m)
        val col = BooleanArray(n)

        //遍历
        for (i in 0 until m){
            for (j in 0 until n){
                if(matrix[i][j] == 0){
                    row[i] = true
                    col[j] = true
                }
            }
        }
        //更新
        for (i in 0 until m){
            for (j in 0 until n){
                if(row[i]|| col[j]){
                    matrix[i][j] = 0
                }
            }
        }





    }
}
//leetcode submit region end(Prohibit modification and deletion)
