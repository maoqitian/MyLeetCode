//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。 
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {

        //连续递增 动态规划 nums[index] > nums[index-1]
        //时间复杂度 O(n)

        if(nums.isEmpty()) return 0

        var index =0 // 开始递增开始 index
        var max = 1

        for ( i in 1 until nums.size){
            if (nums[i] > nums[i-1]){
                //符合递增
                //计算记录最大长度
                max = Math.max(i - index + 1,max)
            }else{
                index = i
            }
        }

        return  max
    }
}
//leetcode submit region end(Prohibit modification and deletion)
