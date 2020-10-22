/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {

        // 双指针 时间复杂度 O(n)
        int [] last = new int[26];
        //获取计算arsii 码数组
        for(int i = 0;i< S.length();i++){
            last[S.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int start=0,end =0;
        for(int i = 0;i< S.length();i++){
            //根据之前计算下表数组获取最大下标
            end = Math.max(end,last[S.charAt(i) - 'a']);
            if(i == end){
                res.add(end - start+1);
                //更新开始位置
                start = end+1;
            }
        }

        return res;
    }
}
// @lc code=end

