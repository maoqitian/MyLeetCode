import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // 将题目核心问题转换 则可变成 a+b = -c 

        //方法一 ： 暴力破解 三层迭代嵌套 时间复杂度 O(n^3)
        // Arrays.sort(nums);
        // Set<List<Integer>> result = new LinkedHashSet<>();

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         for (int k = j+1; k < nums.length; k++) {
        //             if(nums[i]+nums[j]+nums[k] == 0){
        //                 result.add(Arrays.asList(nums[i],nums[j],nums[k]));
        //             }
        //         }
        //     }
        // }
        
        // return new ArrayList<>(result);

        //方法二 ： 使用哈希表HashMap存储 减少一层 迭代嵌套 O(n^2)

        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = hashMap.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    hashMap.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(result);



        //方法三： 双指针往中间推进 左右夹逼 先排好序 然后从左第一个数开始选定 target,
        //target 右边的数则按照双指针往中间推进 左右夹逼 时间复杂度 O(n^2)
        
        /*Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i == 0 || (i>0 && nums[i]!=nums[i-1])){
              int left = i+1,right= nums.length -1, sum = 0 - nums[i]; //target
              while(left < right){
                  if(nums[left] + nums[right] == sum){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //左边界等于左边界加一值 直接跳过，去除重复
                    while (left<right && nums[left] == nums[left+1] ) left++; //移动左边界
                    //右边界等于右边界减一值，直接跳过，去除重复
                    while (left<right && nums[right] == nums[right-1] ) right--; //移动右边界
                    //否则都往中间移动一步
                    left++;
                    right--;
                  }else if(nums[left]+nums[right]<sum){
                      //左边界加上有边界小于目标
                    left++;
                  }else{
                      //左边界加上有边界大于目标
                    right--;
                  }
              }
            }
        } 
        return result;*/
    }
}
// @lc code=end

