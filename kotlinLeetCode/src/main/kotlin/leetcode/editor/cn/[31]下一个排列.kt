//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1154 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun nextPermutation(nums: IntArray): Unit {

        // 时间复杂度 O(n) 题意为寻找较小的 调整位置
        //较小数 index
        var index = nums.size - 2

        while (index >= 0 && nums[index] >= nums[index + 1]){
            index --
        }
        //寻找比 index 较小的
        if (index >= 0){
            var j = nums.size -1
            while (j >= 0 && nums[index] >= nums[j]){
                j--
            }
            //替换位置
            swapNum(nums,index,j)
        }
        //翻转数组
        reverseNums(nums,index+1)
    }

    //翻转数组
    private fun reverseNums(nums: IntArray, startIndex: Int) {
        var left = startIndex
        var right = nums.size - 1

        while (left < right){
            swapNum(nums,left,right)
            left++
            right--
        }
    }

    //交换位置
    private fun swapNum(nums: IntArray, i: Int, j: Int) {
         var temp = nums[i]
         nums[i] = nums[j]
         nums[j] = temp
    }





}
//leetcode submit region end(Prohibit modification and deletion)
