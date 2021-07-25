//有效数字（按顺序）可以分成以下几个部分： 
//
// 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分有效数字列举如下： 
//
// 
// ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
// "53.5e93", "-123.456e789"] 
// 
//
// 部分无效数字列举如下： 
//
// 
// ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"] 
// 
//
// 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = ".1"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。 
// 
// Related Topics 字符串 
// 👍 268 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isNumber(s: String): Boolean {
        //将字符串以 e/E 进行分割后，其实规则十分简单：
        //如果存在 e/E ：左侧可以「整数」或「浮点数」，右侧必须是「整数」
        //如果不存在 e/E ：整段可以是「整数」或「浮点数」
        //关键在于如何实现一个 check 函数用于判断「整数」或「浮点数」：
        //+/- 只能出现在头部
        //. 最多出现一次
        //至少存在一个数字
       //时间复杂度 O(n)
        val n = s.length
        val cs = s.toCharArray()
        var idx = -1
        for (i in 0 until n) {
            if (cs[i] == 'e' || cs[i] == 'E') {
                idx = if (idx == -1) i else return false
            }
        }
        var ans = true
        if (idx != -1) {
            ans = ans and check(cs, 0, idx - 1, false)
            ans = ans and check(cs, idx + 1, n - 1, true)
        } else {
            ans = ans and check(cs, 0, n - 1, false)
        }
        return ans
    }

    private fun check(cs: CharArray, start: Int, end: Int, mustInteger: Boolean): Boolean {
        var start = start
        if (start > end) return false
        if (cs[start] == '+' || cs[start] == '-') start++
        var hasDot = false
        var hasNum = false
        for (i in start..end) {
            if (cs[i] == '.') {
                if (mustInteger || hasDot) return false
                hasDot = true
            } else if (cs[i] in '0'..'9') {
                hasNum = true
            } else {
                return false
            }
        }
        return hasNum
    }
}
//leetcode submit region end(Prohibit modification and deletion)
