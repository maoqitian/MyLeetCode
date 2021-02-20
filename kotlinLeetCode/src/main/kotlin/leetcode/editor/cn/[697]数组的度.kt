
import java.util.*


//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findShortestSubArray(nums: IntArray): Int {
        //两次遍历 时间复杂度 O(n)
        //时间复杂度 O（n）
        var maxCnt = 0
        var res: Int = nums.size
        //数组记录 出现次数 度 左边界 右边界
        //第一次计算出所有的度 使用 HashMap 保存
        var hashMap = HashMap<Int,IntArray>()
        for (i in nums.indices){
            if(hashMap.containsKey(nums[i])){
                hashMap[nums[i]]!![0]++
                hashMap[nums[i]]!![2] = i
            }else{
                hashMap[nums[i]] = intArrayOf(1, i, i)
            }
            maxCnt = Math.max(maxCnt, hashMap.get(nums[i])?.get(0)!!)
        }
        //第二次找到对应相等的度最小长度
        for ((_, arr) in hashMap) {
            if (arr[0] == maxCnt) {
                res = Math.min(res, arr[2] - arr[1] + 1)
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
