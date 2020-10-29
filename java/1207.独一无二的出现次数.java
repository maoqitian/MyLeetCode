/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        //时间复杂度 O(n) 使用 Hash 表 

        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        //计算每个数的个数

        for(int i : arr){
           if(map.containsKey(i)){
              map.put(i,map.get(i)+1);
           }else{
              map.put(i,1);
           }
        }

        //是否存储重复
        for(int key : map.keySet()){
            int count = map.get(key);
            if(!set.contains(count)){
                //如不不存在保存
                set.add(count);
            }else{
                //存在 说明有相同个数 返回 false
                return false;
            }
        }

        return true;

    }
}
// @lc code=end

