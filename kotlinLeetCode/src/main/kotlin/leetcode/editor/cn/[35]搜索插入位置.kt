//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 936 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {

        // 二分查找 时间复杂度 O（log n）
        var left = 0
        var right= nums.size

        while (left < right) {
            var mid = left + (right - left) /2
            if (nums[mid] < target){
                left = mid+1
            }else{
                //在左边
                right = mid
            }
        }
        return left

    }
}
//leetcode submit region end(Prohibit modification and deletion)
