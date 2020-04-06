import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {

        //首先理解题意 异位词表达的是 字母出现次数都是一样 但是顺序不同
        // 方法一 暴力破解 直接对两个字符串排序判断排序后的字符串是否相等
        //时间复杂度 O(nlogn)  n 是字符串的长度

        // char[]s1=  s.toCharArray();
        // char[]s2=  t.toCharArray();

        // Arrays.sort(s1);
        // Arrays.sort(s2);

        // return Arrays.equals(s1, s2);

        //方法二 使用 哈希表 数组 相当于简化的哈希表 时间复杂度 O(n)
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
        }
        for (int i : chars) {
            if(i != 0)
            return false;
        }

        return true;

    }
}
// @lc code=end

