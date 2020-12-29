//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 90 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun missingNumber(nums: IntArray): Int {

        //方法一 等差数列 （1+n）*n/2
        val len = nums.size

        var alltotal = (len+1)*len/2

        var total = 0
        for (i in 0 until len){
            total += nums[i]
        }

        return alltotal - total
        //方法二 二分查找 和前一题类似
        var left = 0
        var right = nums.size-1
        while (left <= right){
            val mid = left + (right - left)/2
            //如果 index 和数组对应数字相等 说明前面都排列正确无漏，往后找
            if(nums[mid] == mid) left = mid+1
            else right = mid-1 //否则不对齐则漏数在当前位置前面
        }

        return left
    }
}
//leetcode submit region end(Prohibit modification and deletion)
