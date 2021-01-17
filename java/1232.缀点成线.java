/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] c) {

        //斜率公式
        //(y1-y0)/(x1-x0)=(yi-y0)/(xi-x0)
        //变化乘积形式
        //(y1-y0)*(xi-x0)==(x1-x0)*(yi-y0)
        //时间复杂度 O(n)

        for (int i = 2;i<c.length;i++){
            if((c[1][1]-c[0][1])*(c[i][0]-c[0][0])!=(c[i][1]-c[0][1])*(c[1][0]-c[0][0])){
             return false;
            }
        }

        return true;

    }
}
// @lc code=end

