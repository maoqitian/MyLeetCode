/*
 * @lc app=leetcode.cn id=679 lang=java
 *
 * [679] 24 点游戏
 */

// @lc code=start
class Solution {

    //dfs 
    final int TARGET = 24; 

    public boolean judgePoint24(int[] nums) {


        if(nums == null || nums.length!=4) return false;

        List<Double> numList = new ArrayList<>();
        for(int i : nums){
           numList.add(i*1.0);
        } 

        return dfs(numList);
    }

    boolean dfs(List<Double> numList){
        //递归结束条件
        if(numList.size() == 1){
          return Math.abs(numList.get(0) - TARGET) < 1e-5;
        }    
        //逻辑处理 进入下层循环
        //选取两个数字进行计算
        for(int i= 0;i<numList.size();i++){
            for(int j= 0;j<numList.size();j++){
              if(i == j) continue;
              List<Double> next = new ArrayList<>();
              for(int k= 0;k<numList.size();k++){
                  if(k!=i && k!=j){
                      next.add(numList.get(k));
                  }
              }

              double n1 = numList.get(i),n2 = numList.get(j);

              // + * 计算
              if(i<j){
                next.add(n1*n2);
                if(dfs(next)){
                    return true;
                }
                next.remove(next.size()-1);

                next.add(n1+n2);
                if(dfs(next)){
                    return true;
                }
                next.remove(next.size()-1);
              }

              // - / 计算
              next.add(n1-n2);
              if(dfs(next)){
                  return true;
              }
              next.remove(next.size()-1);

              next.add(n1/n2);
              if(dfs(next)){
                  return true;
              }
              next.remove(next.size()-1);
            }
        }

        return false;
    }
}
// @lc code=end

