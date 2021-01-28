//给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。 
//
// 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。 
//
// 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。 
//
// 注意：中心索引可能出现在数组的两端。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1, 7, 3, 6, 5, 6]
//输出：3
//解释：
//索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
//同时, 3 也是第一个符合要求的中心索引。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1, 2, 3]
//输出：-1
//解释：
//数组中不存在满足此条件的中心索引。 
//
// 示例 3： 
//
// 
//输入：nums = [2, 1, -1]
//输出：0
//解释：
//索引 0 左侧不存在元素，视作和为 0 ；右侧数之和为 1 + (-1) = 0 ，二者相等。
// 
//
// 示例 4： 
//
// 
//输入：nums = [0, 0, 0, 0, 1]
//输出：4
//解释：
//索引 4 左侧数之和为 0 ；右侧不存在元素，视作和为 0 ，二者相等。
// 
//
// 
//
// 提示： 
//
// 
// nums 的长度范围为 [0, 10000]。 
// 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。 
// 
// Related Topics 数组 
// 👍 280 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun pivotIndex(nums: IntArray): Int {

        //对于中心索引必然有：sum = total - sum - nums[i] （左边值 = 右边值）
        if(nums.isEmpty()) return -1
        //时间复杂度 O(n)
        var total = 0
        var sum = 0
        //累加获取数组总值
        nums.forEach { total += it }

        for ((index,value) in nums.withIndex() ){
            if(sum == total - sum - value){
                return index
            }
            sum += value
        }

        return -1




    }
}
//leetcode submit region end(Prohibit modification and deletion)
