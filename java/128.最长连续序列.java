import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
       
        //想法 遍历当前元素 前后在 set中查找，如果找到直接 删除该元素
        //这样下一个 出现相同元素则会不会重复在set 中查找，并记录删除次数
        
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        
        int res = 0;//返回值
        int removes = 0; //删除次数
        
        int index1 = 0;//指针1 代表当前元素
        int index2 = 0;//指针2代表加一元素

        for (int i = 0; i < nums.length; i++) {
            
            if(!hash.contains(nums[i])) continue;
            removes = 0; //重置
            index1 = nums[i];
            index2 = nums[i]+1;

            while(hash.contains(index1)){
               removes++;
               hash.remove(index1);
               index1-- ; //变成它前面元素
            }
           
            while(hash.contains(index2)){
                removes++;
                hash.remove(index2);
                index2++ ; //变成它后面元素
             }
            
             res = removes > res ? removes:res;

        }
        return res;
    }
}
// @lc code=end

