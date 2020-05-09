import java.util.Arrays;
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

        //ashMap<Integer,Integer> map = countsMap(nums);

        //map 的遍历 
        // Map.Entry<Integer,Integer> majorityelement = null;

        // for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
        //     if(majorityelement == null || entry.getValue()> majorityelement.getValue()){
        //        majorityelement = entry;
        //     }
        // }

        // return majorityelement.getKey();

        //想法二 既然数组中有出现次数> ⌊ n/2 ⌋的元素，那排好序之后的数组中，
        // 相同元素总是相邻的。
        // 即存在长度> ⌊ n/2 ⌋的一长串 由相同元素构成的连续子数组。 
        //Arrays.sort(nums);
        //return nums[nums.length/2];

        //想法三 投票法 时间复杂度 O(n)
        //先推选一个候选人，不相同的元素互相抵消
        //候选人票数为零选取下一个，最后留下的候选人就是票数最多的
        
        //直接选取一个候选人
        int election = nums[0];
        //默认一票
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == election){
               ++count;
            }else if(-- count == 0){
                // 重新选取候选人
                election = nums[i];
                ++count;
            }
        }

        return election;

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

