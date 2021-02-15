//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {

        //遍历计算 1 的个数 时间复杂度 O(n)
        var res = -1
        var count = 0

        nums.forEach {
            if(it == 1){
                count++
            }else{
                count = 0
            }
            res = Math.max(res,count)
        }

        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
