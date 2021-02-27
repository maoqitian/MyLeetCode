//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 380 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        val len: Int = s.length
        var ans = 0
        if (len < k) return 0
        val cnt = IntArray(26)
        for (i in 0 until len) {
            cnt[s[i] - 'a']++
        }
        for (i in 0..25) {
            if (cnt[i] in 1 until k) {
                for (t in s.split((i + 97).toChar())) {
                    ans = Math.max(ans, longestSubstring(t!!, k))
                }
                return ans
            }
        }
        return len

    }
}
//leetcode submit region end(Prohibit modification and deletion)
