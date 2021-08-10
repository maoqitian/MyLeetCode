//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1281 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minWindow(s: String, t: String): String {

        //使用 HashMap 记录含有字符串的数目
        var hashMap = HashMap<Char,Int>()

        if (s.isEmpty() || s.length<t.length) return ""

        t.forEach {
            if (hashMap.containsKey(it)){
                hashMap[it] = hashMap[it]!!+1
            }else{
                hashMap[it] = 1
            }
        }

        //双指针遍历 s
        var left =0
        var minLeft = 0
        var maxRight = s.length + 1
        //累计
        var count = 0

        for (right in s.indices){
            //如果包含当前字符
            var currStr = s[right]
            if(hashMap.containsKey(s[right])){
                hashMap[currStr] = hashMap[currStr]!!-1
                if(hashMap[currStr]!! >= 0){
                    count++
                }
                while (count == t.length){
                    if(right - left+1 < maxRight){
                        minLeft = left
                        maxRight = right - left +1
                    }
                    if(hashMap.containsKey(s[left])){
                        hashMap[s[left]] = hashMap[s[left]]!!+1
                        if(hashMap[s[left]]!! > 0){
                            count--
                        }
                    }
                    left++
                }
            }
        }

        if (maxRight > s.length) return ""

        return s.substring(minLeft,minLeft+maxRight)

    }
}
//leetcode submit region end(Prohibit modification and deletion)
