import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=974 lang=java
 *
 * [974] 和可被 K 整除的子数组
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {

        // 使用 HashMap 逐一统计
        HashMap<Integer,Integer> map = new HashMap<>();
        
        map.put(0, 1);

        int sum = 0,res =0;

        for (int i : A) {
            sum += i;
            //计算摩
            int modules = (sum % K + K) % K;
            int same = map.getOrDefault(modules, 0);
            res += same;
            map.put(modules, same+1); 
        }

        return res;


    }
}
// @lc code=end

