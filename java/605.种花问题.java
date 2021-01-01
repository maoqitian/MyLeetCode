/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //假设在数组左边添加0，以解决边界问题，令零累计初始为1
        //时间复杂度 O(n)

        int plant = 0, zeroCount = 1;

        for(int i = 0;i<flowerbed.length;i++){
           if(flowerbed[i] == 0){
            zeroCount ++;
           }else{
            zeroCount = 0;
           }

           if(zeroCount == 3){
               //连续三个零种一颗
               plant++;
               zeroCount = 1;
           }
        }

        //最后如果剩余两个零则最后一个位置还能种
        if(zeroCount == 2){
          plant++;
        }

        return n <=plant;

    }
}
// @lc code=end

