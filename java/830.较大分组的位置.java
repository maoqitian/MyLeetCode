/*
 * @lc app=leetcode.cn id=830 lang=java
 *
 * [830] 较大分组的位置
 */

// @lc code=start
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        //遍历记录出现相同次数 时间复杂度 O(n)
        List<List<Integer>> res = new ArrayList<>();
        int len = s.length();
        int count = 1;
        for(int i = 0; i < len;i++){
           if(i == len-1 || s.charAt(i) != s.charAt(i+1)){
               if(count >=3){
                   res.add(Arrays.asList(i-count+1,i));
               }
               count = 1;
           }else{
            count++;
        }
        }

        return res;

    }
}
// @lc code=end

