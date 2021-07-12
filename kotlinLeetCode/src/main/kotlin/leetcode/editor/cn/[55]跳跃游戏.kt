//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1260 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canJump(nums: IntArray): Boolean {
        //贪心算法 从后往前数
        //当前 index + 当前可以跳跃步数大于当前下标 说明可以进行跳跃
        //时间复杂度 O(n)
        if(nums.isEmpty()) return false
        //最终下标
        var endIndex = nums.size-1

        for ( i in nums.size-1 downTo 0){
            if(nums[i]+i >= endIndex){
                endIndex = i
            }
        }

        return endIndex == 0
    }
}
//leetcode submit region end(Prohibit modification and deletion)
