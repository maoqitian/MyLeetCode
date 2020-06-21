import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        //循环 先找最大的找零 只有三种面额的钱入账 时间复杂度 O(n)
        //面额 5 块和 10块 的张数

        int five = 0,ten = 0;

        for (int i : bills) {
            if( i == 5){ //五块钱入账
               five++;
            }else if(i == 10){ //10块钱入账
               //无法找零
               if(five == 0)return false;
               five --;
               ten ++;
               }else{ //入账20块

                   if(five >0 && ten>0){ //如果有10块和5块
                      five --;
                      ten--;
                   }else if(five >=3){ //如果有三张5块
                       five = five -3;
                   }else {
                       return false;
                   }
               }
            }
            return true;    
        }
}
// @lc code=end

