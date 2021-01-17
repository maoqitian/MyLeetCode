import kotlin.math.max

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2807 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSubArray(nums: IntArray): Int {

        //动态规划
        //dp[i] 代表当前计算中的最大和
        //动态规划方程
        //dp[i] = Max(dp[i-1]+nums[i],nums[i])

        var dp = IntArray(nums.size)
        dp[0] = nums[0]
        var maxres = dp[0]

        for (i in 1 until nums.size){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i])
            //更新最大值
            maxres = Math.max(dp[i],maxres)
        }

        return maxres
    }
}
//leetcode submit region end(Prohibit modification and deletion)
