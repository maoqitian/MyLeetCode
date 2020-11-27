/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        //思路使用 HashMap 保存 AB 的和，随后 -C-D 的值看是否在HashMap 中
        //时间复杂度 O(n^2)


        HashMap<Integer,Integer> map = new HashMap<>();

        for(int a :A){
            for(int b :B){
                //存在存入 不存在 加一
                map.put(a+b,map.getOrDefault(a+b,0)+1);
            }
        }

        //返回结果值
        int res =0;
        for(int c :C){
            for(int d :D){
                if(map.containsKey(-c-d)){
                    //记录次数
                    res += map.get(-c-d);
                }
            }
        }

        return res;
    }
}
// @lc code=end

