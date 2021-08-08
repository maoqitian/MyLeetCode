//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 475 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        //方法一 暴力破解 时间复杂度 O(m*n)
        //遍历数组
       /* var all = ArrayList<Int>()

        matrix.forEach {
            IntArray->
            IntArray.forEach {
                all.add(it)
            }
        }

        all.forEach {
            if (target == it) return true
        }
        return false*/

        //方法二  二分查找
        if(matrix.isEmpty() || matrix[0].isEmpty())return false

        var row = matrix.size
        var col = matrix[0].size

        var left = 0
        var right = row * col -1

        while (left <= right){
            var mid = left + (right - left)/2

            var midVal = matrix[mid/col][mid%col]
            if(midVal <target){
                left = mid+1
            }else if(midVal > target){
                right = mid -1
            }else{
                return true
            }
        }
        return false

    }
}
//leetcode submit region end(Prohibit modification and deletion)
