//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 192 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        //动态规划 创建 dp 数组 dp[i] 保存对应遍历到位置的最大值
        //动态规划方程
        //dp[i] = max(dp[i-1]+dp[i],dp[i])


        var dp = IntArray(nums.size)
        dp[0] = nums[0]
        var maxres = dp[0]
        for (i in 1 until nums.size){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i])
            maxres = Math.max(maxres,dp[i])
        }

        return maxres


    }
}
//leetcode submit region end(Prohibit modification and deletion)
