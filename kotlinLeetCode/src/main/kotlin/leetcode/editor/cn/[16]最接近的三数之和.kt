import java.util.*
import kotlin.math.abs

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 784 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {

        //双指针 遍历

        Arrays.sort(nums)
        //先随意计算一个结果值
        var res = nums[0]+nums[1]+nums[2]


        for (i in 0 until nums.size){
            var left = i+1
            var right = nums.size -1

            while (left <  right){
                //获取当前遍历的和
                var currSum = nums[i] + nums[left] + nums[right]
                if (Math.abs(target - currSum) < Math.abs(target - res)){
                    //更接近
                    res = currSum
                }

                when{
                    currSum > target ->{
                        right --
                    }
                    currSum < target ->{
                        left++
                    }
                    else -> {
                        //sum = target
                        return target
                    }
                }
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
