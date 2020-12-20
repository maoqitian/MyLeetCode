//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 345 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun removeDuplicateLetters(s: String): String {
//贪心 + 栈 使用数组代替栈 时间复杂度 O(n)
        //贪心 + 栈 使用数组代替栈 时间复杂度 O(n)
        val visit = BooleanArray(26)

        val num = IntArray(26)

        for (i in s.indices) {
            num[s[i] - 'a']++
        }

        val sb = StringBuilder()

        for (element in s) {
            val ch: Char = element
            if (!visit[ch - 'a']) {
                while (sb.isNotEmpty() && sb[sb.length - 1] > ch) {
                    if (num[sb[sb.length - 1] - 'a'] > 0) {
                        visit[sb[sb.length - 1] - 'a'] = false
                        sb.deleteCharAt(sb.length - 1)
                    } else {
                        break
                    }
                }
                visit[ch - 'a'] = true
                sb.append(ch)
            }
            num[ch - 'a'] -= 1
        }
        return sb.toString()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
