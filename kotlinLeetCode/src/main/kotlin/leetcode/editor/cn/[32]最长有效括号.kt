import java.util.*

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1334 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestValidParentheses(s: String): Int {

        //单调栈 时间复杂度 O(n)
        //栈中记录字符 index
        var stack = LinkedList<Int>()
        //保证栈中有元素
        stack.addFirst(-1)

        var maxRes = 0

        for (i in s.indices){
            if(s[i] == '('){
                stack.addFirst(i)
            }else{
                //s[i] == ')'
                //出栈
                stack.removeFirst()
                if(stack.isEmpty()){
                    stack.addFirst(i)
                }else{
                    //计算最大长度
                    maxRes = Math.max(maxRes,i - stack.peek())
                }
            }
        }

        return  maxRes
    }
}
//leetcode submit region end(Prohibit modification and deletion)
