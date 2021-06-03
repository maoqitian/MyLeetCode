//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1815 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun generateParenthesis(n: Int): List<String> {

        //递归
        val res = ArrayList<String>()
        if(n == 0) return res

        generateStr(res,0,0,n,"")

        return res

    }

    private fun generateStr(res: java.util.ArrayList<String>, left: Int, right: Int, n: Int, s: String) {
        //递归结束条件
        if(s.length == n * 2){
            res.add(s)
            return
        }
        //逻辑处理 进入下层循环
        if(left < n){
            generateStr(res,left+1,right,n, "$s(")
        }
        if(right < left){
            generateStr(res,left,right+1,n, "$s)")
        }
        //数据reverse
    }
}
//leetcode submit region end(Prohibit modification and deletion)
