import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {

        //方法一 迭代 时间复杂度 O(n^3)


        


        //方法二 滑动窗口 相当于用一个哈希表存储（可以看做是队列，先进先出） 
        //字符串的每一个字符，如果有相同的，则将最先进来元素找到对应值删除
        //时间复杂度 O(n)

        // 使用 hashmap 存储值 key 为字符 值为index
        if(s.length() == 0) return 0;

        HashMap<Character,Integer> map = new HashMap<>();
        //窗口左边 index
        int left = 0;
        //返回字符串最大长度
        int max = 0;

        //循环遍历字符串的字符
        for(int i = 0; i< s.length(); i++){
            if(map.containsKey(s.charAt(i))){ //如果包含
               //更新左边界index
               left = Math.max(left,map.get(s.charAt(i))+1);
            }
            //否则存储当前字符串
            map.put(s.charAt(i),i);
            // 获取当前字符串长度与最大长度比较, 当前长度减去窗口左边界就是当前字符串长度
            max = Math.max(max,i - left + 1 );
        }
        return max;

    }
}
// @lc code=end

