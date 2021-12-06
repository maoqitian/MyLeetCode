//你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 2, b = [3]
//输出：8
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = [1,0]
//输出：1024
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = [4,3,3,8,5,2]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：a = 2147483647, b = [2,0,0]
//输出：1198
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 231 - 1 
// 1 <= b.length <= 2000 
// 0 <= b[i] <= 9 
// b 不含前导 0 
// 
// Related Topics 数学 分治 
// 👍 194 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var Mod = 1337
    fun superPow(a: Int, b: IntArray): Int {
        return dfs(a,b,b.size-1)
    }

    private fun dfs(a: Int, b: IntArray, i: Int): Int {
        //递归结束条件
        if (i == -1) return 1
        //逻辑处理 进入下层循环
        return pow(dfs(a,b,i-1),10) * pow(a,b[i])%Mod
    }
    
    fun pow(a: Int, b: Int): Int {
        var a = a
        var b = b
        var res = 1
        a %= Mod
        while (b-- > 0) res = res * a % Mod
        return res
    }

}
//leetcode submit region end(Prohibit modification and deletion)
