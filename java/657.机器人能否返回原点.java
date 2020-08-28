/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {

        //上加一 下减一 左减一 右加一 时间复杂度 O(n)

        int x =0, y =0;

        for(int i = 0; i< moves.length();i++){

            if(moves.charAt(i) == 'L'){
                x -= 1;
            }else if(moves.charAt(i) == 'R'){
                x += 1;
            }else if(moves.charAt(i) == 'U'){
                y += 1;
            }else if(moves.charAt(i) == 'D'){
                y -= 1;
            }
        }

        return x == 0 && y == 0;

    }
}
// @lc code=end

