//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 数组 
// 👍 780 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun singleNumber(nums: IntArray): Int {

        var map = HashMap<Int,Int>()

        nums.forEach {
            if (map.containsKey(it)){
                map.put(it,map.get(it)!!+1)
            }else{
                map.put(it,1)
            }
        }

        map.forEach { (t, u) ->
            if (u == 1)  return t
        }
        return -1
        var res = 0

        for (i in 0..31) {
            val mask = 1 shl i
            var cnt = 0
            for (j in 0 until nums.size) {
                if (nums[j] and mask !== 0) {
                    cnt++
                }
            }
            if (cnt % 3 != 0) {
                res = res or mask
            }
        }

        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
