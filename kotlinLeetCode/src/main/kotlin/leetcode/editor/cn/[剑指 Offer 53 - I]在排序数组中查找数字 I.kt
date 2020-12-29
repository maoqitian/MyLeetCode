//统计一个数字在排序数组中出现的次数。
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 83 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        //排序数组 二分查找 寻找左右边界 相减则为重复数字的次数
        //左边界则为当前 target 减一
        return find(nums,target) - find(nums,target-1)
    }

    fun find(nums: IntArray,target: Int):Int {
        var left = 0
        var right = nums.size-1

        while(left <= right){
            var mid = left + (right-left)/2
            if(nums[mid] <= target){
                left = mid+1
            }else {
                right = mid-1
            }
        }
        return left
    }
}
//leetcode submit region end(Prohibit modification and deletion)
