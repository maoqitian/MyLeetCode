/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {

        //方法一 直接转换成字符串 暴力破解
        // if(x < 0 || (x % 10 == 0 && x!=0)) return false;

        // String s = String.valueOf(x);

        // int left = 0, right = s.length()-1;

        // while(left<=right){
        //    if(s.charAt(left) == s.charAt(right)){
        //       left ++;
        //       right -- ;
        //    }else{
        //        return false;
        //    }
        // }
        // return true;

        //方法二 进阶 不使用字符串 可以从个位数开始组成新的数字，记录到一半与当前数字相等
        //说明是回文数，否则大于当前数


        if(x < 0 || (x % 10 == 0 && x!=0)) return false;
        int reveNum = 0;

        while(x > reveNum){
            // x % 10 获取个位数 然后加上原本个位数移动到十位数上的值，也就是反转的数据
            reveNum = x % 10 + reveNum*10;
            // 继续获取 原本数下一个位
            x = x /10;
        }
// 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == reveNum || x == reveNum / 10;

    }
}
// @lc code=end

