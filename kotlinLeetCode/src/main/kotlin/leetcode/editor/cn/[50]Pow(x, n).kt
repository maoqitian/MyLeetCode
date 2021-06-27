//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 递归 数学 
// 👍 673 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun myPow(x: Double, n: Int): Double {
        //递归分治
        //指数
        var n1 = n
        var value = x
        //处理符号 让负 指数 变成 正数
        if(n1 < 0 ){
            n1 = -n1
            value = 1/value
        }

        return dfsPow(n1,value)
    }

    private fun dfsPow(n: Int, value: Double): Double {
        //递归结束条件
        //指数为1 返回1
        if(n == 0) return 1.0

        //逻辑处理进入下层循环
        //分别化为为对半最小单位进行计算
        var halfVal = dfsPow(n/2,value)

        //根据奇偶性继续计算
        return if(n % 2 == 0){
            halfVal*halfVal
        }else{
            halfVal*halfVal*value
        }

        //数据rever
    }
}
//leetcode submit region end(Prohibit modification and deletion)
