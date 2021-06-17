//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1106 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        //算法 原地 Hash  [1,N] 区间
        // 也就是 遍历一次让 位置  0 存放 1  1存放 2 以此类推
        //第二次遍历数组 当前 位置 0 值不等于 0+1 则返回该位置的 index +1
        //否则最后返回 数组长度+1 代表最小整数

        for( i in nums.indices){
            while (nums[i] >= 1 && nums[i] <= nums.size && nums[nums[i]-1] != nums[i]){
                //交换到正确的位置
                swapNum(nums,i,nums[i]-1)
            }
        }
        //第一次遍历 尽可能排放在正确位置
        for (i in nums.indices){
            if (nums[i] -1 != i){
                return i+1
            }
        }

        return nums.size+1

    }

    private fun swapNum(nums: IntArray, i: Int, j: Int) {
        var temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}
//leetcode submit region end(Prohibit modification and deletion)
