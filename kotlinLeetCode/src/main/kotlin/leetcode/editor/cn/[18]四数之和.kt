import java.util.*
import kotlin.collections.ArrayList

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 857 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {

        //双指针  时间复杂度 O(n^3)
        val res: MutableList<List<Int>> = ArrayList()

        val length: Int = nums.size

        //排序好数组
        Arrays.sort(nums)

        if (length == 0) return res

        for (a in 0 until length - 3) { //开头指针
            //相等跳过当前数
            if (a > 0 && nums[a] == nums[a - 1]) continue
            for (d in length - 1 downTo a + 2 + 1) { //末尾指针
                //相等跳过当前数
                if (d < length - 1 && nums[d] == nums[d + 1]) continue
                //确定另外两数index
                var b = a + 1
                var c = d - 1
                //当前和最小值
                val min = nums[a] + nums[d] + nums[b] + nums[b + 1]
                if (min > target) continue
                //当前和最大值
                val max = nums[a] + nums[d] + nums[c - 1] + nums[c]
                //不在当前范围
                if (max < target) break
                while (c > b) {
                    //继续以 c b 为指针寻找
                    val sum = nums[a] + nums[b] + nums[c] + nums[d]
                    when {
                        sum > target -> c--
                        sum < target -> b++
                        else -> {
                            res.add(listOf(nums[a], nums[b], nums[c], nums[d]))
                            while (c > b && nums[b] == nums[b + 1]) b++
                            while (c > b && nums[c] == nums[c - 1]) c--
                            b++
                            c--
                        }
                    }
                }
            }
        }

        return res


    }
}
//leetcode submit region end(Prohibit modification and deletion)
