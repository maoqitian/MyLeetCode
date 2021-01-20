import java.util.*
import kotlin.math.max

//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maximumProduct(nums: IntArray): Int {

        //如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数相乘同样也为最大乘积。
        //如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积。
        //线性扫描得出最大 第二段 第三大 最小 第二小的数

//        //排序 时间复杂度 O（nlogn）
//        Arrays.sort(nums)
//        val len = nums.size
//        return Math.max(nums[len-1]*nums[len-2]*nums[len-3],nums[0]*nums[1]*nums[len-1])

        //方法二 线性扫描
        // 最小的和第二小的
        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE
        // 最大的、第二大的和第三大的
        var max1 = Int.MIN_VALUE
        var max2 = Int.MIN_VALUE
        var max3 = Int.MIN_VALUE

        nums.forEach {
            //找最小和第二小
            if(it < min1){
                min2 = min1
                min1 = it
            }else if(it < min2){
                min2 = it
            }

            if(it > max1){
                max3 = max2
                max2 = max1
                max1 = it
            }else if (it > max2){
                max3 = max2
                max2 = it
            }else if(it > max3){
                max3 = it
            }
        }
        return Math.max(max1*max2*max3,min1*min2*max1)

    }
}
//leetcode submit region end(Prohibit modification and deletion)
