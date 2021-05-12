import kotlin.math.max

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5445 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

       //滑动窗口 map 保存字符和下标 遍历更新最大长度
       //时间复杂度 O(n)
        val map = HashMap<Char,Int>()
        var resMax = 0
        //左边界
        var left = 0
        for (index in s.indices){
            if (map.containsKey(s[index])){
                //相同跳过继续更新左边界
                left = Math.max(left, map[s[index]]!!+1)
            }
            //存入
            map[s[index]] = index
            //更新最大值
            resMax = Math.max(resMax,index - left +1)
        }

        return resMax

    }
}
//leetcode submit region end(Prohibit modification and deletion)
