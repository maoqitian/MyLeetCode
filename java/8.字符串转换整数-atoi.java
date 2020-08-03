/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {

        //首先去除空格 时间复杂度 O(n)
        str = str.trim();
        //边界判断
        if(str.length() == 0 )return 0;
        //如果去除空格后第一个字符串不满足条件 返回 0
        if(!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' &&str.charAt(0) != '+') return 0;

        //返回值
        long res =0L;

        //符号
        boolean neg = str.charAt(0) == '-';

         //确定遍历 index
         int index = !Character.isDigit(str.charAt(0)) ? 1 : 0;

        while(index < str.length()&&Character.isDigit(str.charAt(index))){
            //如果为数字 并且没有超过最大长度
            //计算结果
            res = res*10 + (str.charAt(index++)-'0');
            if(!neg && res > Integer.MAX_VALUE){
              //如果为正数并且大于 int 最大值
              res = Integer.MAX_VALUE;
              break;
            }
            if(neg && res > 1L + Integer.MAX_VALUE){
                //如果为负数并且大于 int 最大值
                res = 1L + Integer.MAX_VALUE;
                break;
              }
        }

        return neg ?(int) - res :(int) res; 
    }
}
// @lc code=end

