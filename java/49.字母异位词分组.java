import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //使用 hashMap 存储 ，字母异位词作为key ，value 为 list 集合

        HashMap<String,List<String>> map = new HashMap<>();

        for (String string : strs) {
            char[] c = string.toCharArray();
            //排序
            Arrays.sort(c);
            //转化为字符串
            String key = String.valueOf(c);
            if( !map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            //将当前字符串存入对应 key 集合
            map.get(key).add(string);
        }

        return new ArrayList(map.values());


    }
}
// @lc code=end

