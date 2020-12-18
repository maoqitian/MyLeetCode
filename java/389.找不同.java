/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {

        //将字符串 s和t 中每个字符的 ASCII 码的值求和相减就是多出字符值
        int snum = 0,tnum = 0;

        //一个循环同时计算两个值
        for(int i = 0;i < t.length();i++){
            //不操作 s 字符长度
            if(i < s.length()){
                snum += s.charAt(i);
            }
            tnum += t.charAt(i);
        }

        return (char)(tnum-snum);

    }
}
// @lc code=end

