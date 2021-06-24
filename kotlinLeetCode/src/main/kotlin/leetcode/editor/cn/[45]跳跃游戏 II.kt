//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 动态规划 
// 👍 1026 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun jump(nums: IntArray): Int {

        var res = 0

        var end = 0
        //当前能走到的最大路径
        var maxPair = 0

        for ( i in 0 until nums.size-1){
            //当前位置的值加上index表达能到达的最远位置
            maxPair = Math.max(maxPair,nums[i]+i)

            if (end == i){
                end = maxPair
                res++
            }
        }

        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
