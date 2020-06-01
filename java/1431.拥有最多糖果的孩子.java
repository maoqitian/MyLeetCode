import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {


        //两个循环 首先找出最大值 然后遍历 设置 返回数组值 时间复杂度 O(n)

        List<Boolean> res = new ArrayList<>();
        int max = candies[0];
        for (int i : candies) {
            max = Math.max(max, i);
        }

        for (int i : candies) {
            if((i+extraCandies) >= max){
              res.add(true);
            }else{
                res.add(false);
            }
        }

        return res;

    }
}
// @lc code=end

