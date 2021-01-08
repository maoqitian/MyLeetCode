import java.util.*
import java.util.Collections.reverse

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 834 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        //暴力破解 手动首位交换 时间复杂度 O（n*k）
        var temp =0
        var pre = 0
        for (i in 0 until k){
            pre = nums[nums.size-1]
            for (j in nums.indices){
               temp = nums[j]
               nums[j] = pre
               pre = temp
            }
        }
/**=======================================================*/
        //方法二 新数组保存偏移位置 i = (i+k)%nums.size
        //在赋值回原数组 时间复杂度 O（n）
        var tempNums = IntArray(nums.size)

        for (i in nums.indices){
            tempNums[(i+k)%nums.size] = nums[i]
        }
        //赋值回原数组
        for(i in nums.indices){
            nums[i] = tempNums[i]
        }
/**=======================================================*/

        //方法三 全部反转后 前K个反转 后 n-k 个反转
        // 时间复杂度 O(n) 空间复杂度 O(1)

        var k1 = k % nums.size
        //反转全部
        reverse(nums, 0, nums.size-1);
        //翻转前K个
        reverse(nums, 0, k1-1);
        //翻转 nums.length -k 个
        reverse(nums, k1, nums.size-1);

    }
    //数组翻转
    fun reverse(nums: IntArray, start: Int, end: Int) {
        var start = start
        var end = end
        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start++
            end--
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
