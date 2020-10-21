/*
 * @lc app=leetcode.cn id=925 lang=java
 *
 * [925] 长按键入
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {

        //双指针 逐个匹配 时间复杂度 O(n+m) n m 为字符串长度

        int left = 0,left1 = 0;

        while(left1 < typed.length()){
           if(left < name.length() && name.charAt(left) == typed.charAt(left1)){
              //如果字符串匹配相等 移动指针
              left++;
              left1++;
           }else if(left1 > 0 && typed.charAt(left1) == typed.charAt(left1-1)){
             // 输入字符当前位置和前一个相等
             left1++;
           }else{
               //字符串不匹配
               return false;
           }
        }

        //是否已经匹配完成
        return left == name.length();
    }
}
// @lc code=end

