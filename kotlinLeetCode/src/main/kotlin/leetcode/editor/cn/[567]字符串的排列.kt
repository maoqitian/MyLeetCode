//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 268 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var n = s1.length
        var m = s2.length
        if(n > m) return false
        var count = IntArray(26)
        for (i in 0 until n){
            --count[s1[i] - 'a']
        }

        var left =0
        for (right in 0 until m){
            var x = s2[right] - 'a'
            ++count[x]
            while(count[x] > 0){
                // 匹配
                --count[s2[left] -'a']
                ++left
            }
            if(right - left +1 == n) return true

        }

        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
