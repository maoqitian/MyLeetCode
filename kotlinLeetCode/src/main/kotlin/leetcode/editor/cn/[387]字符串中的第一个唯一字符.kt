//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 332 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun firstUniqChar(s: String): Int {

        if(s.isEmpty()) return -1

        //使用 HashMap 保存每个字符个数
        val map = HashMap<Char,Int>()
        for (i in s.indices){
            if (map.containsKey(s[i])){
                map[s[i]] = map[s[i]]!!+1
            }else{
                map[s[i]] = 1
            }
        }

        var res = -1
        for (i in s.indices){
            if (map[s[i]]!! < 2){
                res = i
                break
            }
        }

        return  res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
