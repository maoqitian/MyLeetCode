//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 
//
// 注意： 
//
// 
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2450 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reverse(x: Int): Int {

        //遍历取余 注意溢出
        if(x == Int.MAX_VALUE) return 0
        var temp = x
        var res =0
        while (temp !=0){
            //获取余数
            var tail = temp % 10
            //计算当前值结果
            var newRes = res*10 + tail
            //判断是否溢出
            if((newRes-tail)/10!= res) return 0

            //更新结果值
            res = newRes
            //继续翻转
            temp = temp/10
        }
         return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
