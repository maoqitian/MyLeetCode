//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。 
// 
//
// 示例： 
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= customers.length == grumpy.length <= 20000 
// 0 <= customers[i] <= 1000 
// 0 <= grumpy[i] <= 1 
// 
// Related Topics 数组 Sliding Window 
// 👍 138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
        //滑动窗口 时间复杂度 O(n)
        //滑动窗口  最大满意 = 原本满意 + 使用特殊方法最大满意

        //原本满意的人
        var count = 0

        //计算不使用特殊方法原本满意的人
        //使用特殊方法满意的人
        var res = 0
        for (i in 0 until customers.size) {
            if (grumpy[i] === 0) count += customers[i]
        }


        //计算初始值 使用特殊方法满意人数
        var max = 0
        for (i in 0 until X) {
            max += customers[i] * grumpy[i]
        }


        //滑动窗口
        res = max
        for (i in X until customers.size) {
            max = max - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i]
            res = Math.max(res, max)
        }

        return res + count

    }
}
//leetcode submit region end(Prohibit modification and deletion)
