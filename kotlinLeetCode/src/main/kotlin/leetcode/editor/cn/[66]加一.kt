//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 数学 
// 👍 722 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun plusOne(digits: IntArray): IntArray {

        //从后往前遍历 加一 时间复杂度 O(n)

        for (i in digits.size-1 downTo 0){
            digits[i] ++
            //查看是否有进位
            digits[i] = digits[i]%10
            if (digits[i] !=0){
                //说明没有进位 返回原数组
                return digits
            }
        }

        //原数组一直有进位 扩充原数组
        val digits1 = IntArray(digits.size+1)
        digits1[0] = 1
        return digits1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
