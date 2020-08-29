/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {

      //遍历相加 时间复杂度 O(n)

      for(int i= digits.length -1;i>=0;i--){
        //先加1
        digits[i]++;
        digits[i] = digits[i]%10;
        if(digits[i] !=0){
          //说明没有进位 直接返回数组
          return digits;
        }
    }
    //到此说明一直产生进位 则扩大数组长度并给第一位赋值1
    digits = new int[digits.length+1];
    digits[0] =1;
    return digits;

    }
}
// @lc code=end

