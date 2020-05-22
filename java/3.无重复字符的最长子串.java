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

        int maxLenght = 0; //匹配出的字符串的长度
        int left = 0;//存储字符串的重复 长度

        if (s.length()==0) return 0;
        //以字符串为key 值记录字符串位置 也就是长度
        HashMap<Character,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(hashMap.containsKey(s.charAt(i))){
                //包含相同则加一 
                left = Math.max(left,hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            //最终求出 减去重复长度剩下就是不重复的
            maxLenght = Math.max(maxLenght, i - left +1);
        }
        return maxLenght;

    }
}
// @lc code=end

