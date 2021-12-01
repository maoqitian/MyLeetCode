//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。 
// 
// Related Topics 数学 二分查找 
// 👍 267 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findNthDigit(n: Int): Int {
        var len = 1

        var n1 =n

        while (len * 9 * Math.pow(10.0, len - 1.toDouble()) < n1) {
            n1 -= ( len * 9 * Math.pow(10.0, len - 1.toDouble())).toInt()
            len++
        }

        var s = Math.pow(10.0, len - 1.toDouble()).toLong()

        s += n1 / len - 1
        n1 -= len * (n1 / len)
        return if (n1 == 0) (s % 10).toInt() else ((s + 1) / Math.pow(10.0, (len - n1).toDouble()) % 10).toInt()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
