import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {

        //使用 HashMap 时间复杂度 O(n)

        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        int count = 0;
        //放入初始数据

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(map.containsKey(sum-k)){
               count = count + map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }
}
// @lc code=end

