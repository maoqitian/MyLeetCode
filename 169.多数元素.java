import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {

        //思想一 使用HashMap 保存每个说出现的次数 时间复杂度 O(n)

        HashMap<Integer,Integer> map = countsMap(nums);

        //map 的遍历 
        Map.Entry<Integer,Integer> majorityelement = null;

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(majorityelement == null || entry.getValue()> majorityelement.getValue()){
               majorityelement = entry;
            }
        }

        return majorityelement.getKey();
    }

    private HashMap<Integer,Integer> countsMap(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
          for (int i : nums) {
              if(map.containsKey(i)){
                  //如果已经出现过该数字 加一 
                 map.put(i, map.get(i)+1);
              }else{
                  //否则存入
                  map.put(i, 1);
              }
          }

          return map;
    }
}
// @lc code=end

