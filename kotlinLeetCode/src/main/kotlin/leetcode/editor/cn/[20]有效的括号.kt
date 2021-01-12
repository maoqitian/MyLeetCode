import java.util.*

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2086 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isValid(s: String): Boolean {

        //使用栈先进后出 逐个匹配
        //时间复杂度 O（n）

        if (s.length<=1) return false
        var stack = LinkedList<Char>()

        s.forEach {
            if (it == '{'){
                stack.addFirst('}')
            }else if(it == '['){
                stack.addFirst(']')
            }else if (it == '('){
                stack.addFirst(')')
            }else if(stack.isEmpty() || stack.removeFirst() != it){
                return  false
            }
        }

        return  stack.isEmpty()

    }
}
//leetcode submit region end(Prohibit modification and deletion)
