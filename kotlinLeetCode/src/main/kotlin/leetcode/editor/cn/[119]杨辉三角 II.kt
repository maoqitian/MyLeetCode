
import java.util.*


//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 252 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun getRow(rowIndex: Int): List<Int> {
//数学二项式
        // n 行的第 i个数等于第 n−1 行的第 i-1个数和第 i个数之和
        

        val res: MutableList<Int> = ArrayList<Int>(rowIndex + 1)
        var cur: Long = 1
        for (i in 0..rowIndex) {
            res.add(cur.toInt())
            cur = cur * (rowIndex - i) / (i + 1)
        }
        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
