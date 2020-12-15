//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法 
// 👍 140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun monotoneIncreasingDigits(N: Int): Int {
        //数字转化为字符数组
        val numsArray = N.toString().toCharArray()
        //获取需要转变为 9 的前一个index 默认是数最后一位 贪心算法
        //时间复杂度O(n)
        var flag = numsArray.size

        for (i in numsArray.size-1 downTo 1){
            if (numsArray[i-1] > numsArray[i]){
                flag = i;
                numsArray[i-1]--
            }
        }
        //将从flag 位置开始剩余位置设置为 9
        for(i in flag until numsArray.size){
            numsArray[i] = '9'
        }
        return String(numsArray).toInt()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
