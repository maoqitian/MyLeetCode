import java.lang.StringBuilder
import java.util.*

//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 
// 👍 543 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun getPermutation(n: Int, k: Int): String {

        // 减枝 找到会在某个数开头 使用数组模拟 时间复杂度 O(n^2)
        // 相当于在 n 个数字的全排列中找到下标为 k - 1 的那个数，因此 k 先减 1
        var k1 = k
        k1--

        //记录每个位置值数组
        var f = IntArray(n)
        //第一个位置默认为1
        f[0] = 1

        //计算所有位置阶乘枝 保持在数组中
        for (i in 1 until n){
            f[i] = f[i-1]*i
        }

        var linkerNum  = LinkedList<Int>()
        //链表中记录位置
        for (i in 1..n){
            linkerNum.add(i)
        }
        //计算 拼接 第 k 个排列。
        var sb = StringBuilder()

        for (i in n-1 downTo 0){
            //i 标识剩余可选数字个数 初始为 n -1
            var index = k1/f[i]
            sb.append(linkerNum.removeAt(index))
            k1 -= index * f[i]
        }

        return sb.toString()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
