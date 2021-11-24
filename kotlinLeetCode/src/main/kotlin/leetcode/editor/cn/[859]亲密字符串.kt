//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。 
//
// 
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。 
//
// 示例 2： 
//
// 
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。 
//
// 示例 3： 
//
// 
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
// 
//
// 示例 4： 
//
// 
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, goal.length <= 2 * 104 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 
// 👍 220 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun buddyStrings(s: String, goal: String): Boolean {
        //字符串长度不相等, 直接返回false
        if(s.length != goal.length) return false
        //字符串相等的时候, 只要有重复的元素就返回true
        if(s == goal)
            return hasSmaeChar(s)
        //A, B字符串有不相等的两个地方, 需要查看它们交换后是否相等即可.
        else
            return canExchange(s, goal)
    }
    //字符串不同 交换判断是否相等
    private fun canExchange(s: String, goal: String): Boolean {
        var intArray = IntArray(2)
        var j = 0
        for (i in s.indices){
            if (s[i] != goal[i]){
                if (j == 2) return false
                //是否有相等的字符 记录下标
                intArray[j] = i
                j++
            }
        }
        if (j == 0) return false
        return s[intArray[0]] == goal[intArray[1]] && s[intArray[1]] == goal[intArray[0]]
    }
    //字符串是否有重复元素
    private fun hasSmaeChar(s: String): Boolean {

        if (s.length > 26) return true
        for (i in s.indices){
            for (j in i+1 until s.length){
                if (s[i] == s[j]){
                    return true
                }
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
