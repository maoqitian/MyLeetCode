import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 596 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        //使用HashMap 存储相同字母的数组 时间复杂度 O(n)
        val map = HashMap<String,ArrayList<String>>()
        for (string in strs){

            val cArray = string.toCharArray()
            Arrays.sort(cArray)
            //排好序的字符串
            val s = String(cArray)
            if (!map.containsKey(s)) map[s] = ArrayList()
            map[s]?.add(string)
        }

        return ArrayList(map.values)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
