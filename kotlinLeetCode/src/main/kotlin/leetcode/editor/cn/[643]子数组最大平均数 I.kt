//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {

        //滑动窗口 时间复杂度 O(n)
        //返回值 和 k 长度窗口和
        var res = 0.0
        var sum = 0.0
        //获取初始前 k 和赋值 res
        for (i in 0 until k){
            sum += nums[i]
        }

        res = sum/k

        for (i in k until nums.size){
            sum = sum + nums[i] - nums[i-k]
            res = Math.max(res,sum/k)
        }

        return res


    }
}
//leetcode submit region end(Prohibit modification and deletion)
