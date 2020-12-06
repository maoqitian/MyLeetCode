/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //数学二项式
        // n 行的第 ii个数等于第 n−1 行的第 i-1个数和第 i个数之和
        List<List<Integer>> res  = new ArrayList<>();
        
        for(int i = 0; i <numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i;j++){
                if(j == 0 || j == i){
                   //开头结尾固定为一
                   temp.add(1);
                }else{
                    temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }

            }
            //加入每一行结果
            res.add(temp);
        }

        return res;
    }
}
// @lc code=end

