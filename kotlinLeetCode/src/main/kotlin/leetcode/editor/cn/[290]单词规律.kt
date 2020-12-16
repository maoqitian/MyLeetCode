//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 270 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {

        //使用 HashMap 存储对应值元素 时间复杂度 O(n)
        val ss = s.split(" ")
        if(pattern.length != ss.size) return false

        val map = HashMap<Char,String>()

        for ( i in pattern.indices){
            val c = pattern[i]
            if(map.containsKey(c)){
                if(!map[c].equals(ss[i])) return false
            }else {
                if(map.containsValue(ss[i])){
                    return false
                }else{
                    map[c] = ss[i]
                }
            }
        }
        return true

    }
}
//leetcode submit region end(Prohibit modification and deletion)
