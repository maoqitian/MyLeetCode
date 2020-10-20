/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String S, String T) {

        //方法一 将字符串退格符前一个字符删除 最后比较字符串是否相等
        //时间复杂度 O(n+m) n m 为字符串 s 和 t 的长度

        return buildString(S).equals(buildString(T));
    }

    String buildString(String s){
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c!='#'){ 
                //如果不是退格符 拼接
                sb.append(c);
            }else{
                //是退格符 删除上次拼接的最后一个字符
                if(sb.length() > 0){
                   sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();

    }
}
// @lc code=end

