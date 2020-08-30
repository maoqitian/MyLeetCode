/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {

        //转换字符串数组 逐个翻转 拼接 时间复杂度 O(n)

        List<String> strList = new ArrayList<>(Arrays.asList(s.split(" ")));

        StringBuilder stringBuilder = new StringBuilder();

        for(String str : strList){

            stringBuilder.append(new StringBuffer(str).reverse());
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();

    }
}
// @lc code=end

