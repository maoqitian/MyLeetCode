/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {

        //遍历相加 等位相加 反转 时间复杂度 O（n）
        int i =a.length()-1,j=b.length()-1,carry =0;//初始指针 和相加进位

        StringBuilder stringBuilder = new StringBuilder();

        while(i>=0 || j>=0){
             
            // “0” 字符的 ASC 码为48 对应为 0 ，字符串ASE 减去零 等于对应的int值
            int sum = carry;
            if(i>=0) sum += (a.charAt(i--) - '0');
            if(j>=0) sum += (b.charAt(j--) - '0');
            //拼接进位
            stringBuilder.append(sum%2);
            //是否有进位
            carry = sum/2;
        }

        if(carry!=0) stringBuilder.append(carry);

        return stringBuilder.reverse().toString();
        
    }
}
// @lc code=end

