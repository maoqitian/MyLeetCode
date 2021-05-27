import java.util.*

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1616 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
         //最长公共前缀，先排序保证 第一个元素和最后一个元素的第一个字符相等，不相等随后直接返回
         //时间复杂度 O(n)
         Arrays.sort(strs)
         //记录相同的 前缀 index
         var index = 0
         var first = strs[0]
         var last = strs[strs.size-1]

         while (index < first.length){
             if(first[index] == last[index]){
                 index++
             }else{
                 break
             }
         }

        return if(index == 0) "" else first.substring(0,index)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
