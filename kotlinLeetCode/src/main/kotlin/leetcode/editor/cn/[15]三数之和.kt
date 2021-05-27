import java.util.*

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3369 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {


        //双指针 求三数之和
        //先排序
        Arrays.sort(nums)
        var res :MutableList<List<Int>> = LinkedList()

        for (i in 0 until nums.size){
                if(i == 0 || (i >0 && nums[i] != nums [i-1])){
                    //左右指针
                    var left = i+1
                    var right = nums.size -1
                    while(left < right){
                        when {
                            nums[left] + nums[right] == 0 - nums[i] -> {
                                res.add(mutableListOf(nums[i],nums[left],nums[right]))
                                //去除重复计算
                                while(left<right && nums[left] == nums[left+1]) left++
                                while(left<right && nums[right] == nums[right-1]) right--
                                //否则都进一步
                                left++
                                right--
                            }
                            nums[left] + nums[right] > 0 - nums[i] -> {
                                //大于
                                right --
                            }
                            else -> {
                                //小于
                                left++
                            }
                        }
                    }
                }
            }
        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
