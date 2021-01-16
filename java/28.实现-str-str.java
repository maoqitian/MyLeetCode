/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {


        //双指针

        int index1 = 0,index2 = 0;

        while(index1 < haystack.length() && index2 < needle.length()){

            if(haystack.charAt(index1) == needle.charAt(index2)){
                //如果找到对应第一次字符
                index1++;
                index2++;
            }else{
                //否则重置 index
                index1 = index1 - index2+1;
                index2 = 0;
            }
        }

        return needle.length() == index2 ? index1 - needle.length() : -1;

    }
}
// @lc code=end

