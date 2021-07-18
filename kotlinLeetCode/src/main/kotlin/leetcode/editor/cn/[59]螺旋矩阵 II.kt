//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 444 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {

        //返回结果
        val arr = Array(n) { IntArray(n) }

        //数组矩阵初始值
        var startVal = 1
        //当前计算矩阵旋转 index
        var index = 0
        while (startVal <= n*n){
            //左到右
            for (i in index until n -index)
                arr[index][i] = startVal++

            //上到下
            for (i in index+1 until n -index)
                arr[i][n-index - 1] = startVal++

            //右到左
            for (i in n - index - 2 downTo index)
                arr[n - index - 1][i] = startVal++
            //下到上
            for (i in n - index - 2 downTo index + 1)
                arr[i][index] = startVal++

            index++
        }

        return arr
    }
}
//leetcode submit region end(Prohibit modification and deletion)
