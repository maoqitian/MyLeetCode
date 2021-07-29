//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 730 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun mySqrt(x: Int): Int {
        //二分查找
        //时间复杂度 O(logn)
        if(x == 0 || x == 1) return x

        var left = 0
        var right = x
        var res = -1

        while(left <= right){
            val mid = left + (right - left)/2
            //如果当前值得平方小于等于 x 说明找到相近的
            if (mid * mid.toLong() <= x){
                res = mid
                left = mid+1
            }else{
                //太大继续缩小范围
                right = mid -1
            }
        }


        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
