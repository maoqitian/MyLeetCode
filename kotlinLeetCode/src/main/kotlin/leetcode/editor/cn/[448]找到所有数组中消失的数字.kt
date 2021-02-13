//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 609 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        //使用数组的下标来标记数字的出现于否，通过一遍遍历即可标记出全部已经出现的数组
        //是否复杂度 O(n)

        var res = ArrayList<Int>()

        for (i in 0 until nums.size){
            if (nums[Math.abs(nums[i]) -1] > 0){
                nums[Math.abs(nums[i]) -1] = - nums[Math.abs(nums[i]) -1]
            }
        }

        for (i in 0 until nums.size){
            if(nums[i] > 0){
                res.add(i+1)
            }
        }

        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
