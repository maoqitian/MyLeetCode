//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 812 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        //获取上下左右边界 然后遍历获取就行
        var res = ArrayList<Int>()

        if(matrix.isEmpty()) return res

        var left = 0
        var top =  0
        var right = matrix[0].size -1
        var bottom = matrix.size -1

        while (true){
            //左到右
            for (i in left ..right){
                res.add(matrix[top][i])
            }
            if(++top> bottom){
                //如果上边界到达底部
                break
            }
            //上到下
            for (i in top ..bottom){
                res.add(matrix[i][right])
            }
            //如果右边界到左边界
            if (left>--right) break
            //右到左
            for (i in right downTo left){
                res.add(matrix[bottom][i])
            }
            //如果到达上边界
            if (top>--bottom) break
            //下到上
            for (i in bottom downTo top){
                res.add(matrix[i][left])
            }
            //如果左边界到右边界
            if (++left>right) break
        }

        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
