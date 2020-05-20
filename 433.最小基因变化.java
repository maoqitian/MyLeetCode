import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {

    //想法 深度优先 递归 回溯
    //最下步骤 声明
    int minStepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        
        dfs(new HashSet<String>(),0,start,end,bank);

        return (minStepCount == Integer.MAX_VALUE)? -1 : minStepCount;
    }

    /**
     * 
     * @param setp 存储基因组 集合 不可重复
     * @param setpCount 当前次数
     * @param currentStr 当前基于组
     * @param end 目标基于组
     * @param bank 基因库
     */
    void dfs(HashSet<String> setp,int setpCount,String currentStr,String end,String[] bank){
       //递归结束条件
       if(setpCount >= minStepCount){
          return;
       }
       //逻辑处理 进入下层递归
       //如果已经匹配到 更新次数
       if(currentStr.equals(end)){
          minStepCount = Math.min(setpCount, minStepCount);
       }
       //遍历基于库
       for (String str : bank) {
           int diff = 0;
           for (int i = 0; i < str.length(); i++) {
                  if(currentStr.charAt(i) != str.charAt(i)){
                    diff++;
                    if(diff > 1) break;
                  }
                       
           }
           if(diff == 1 && !setp.contains(str)){
            setp.add(str);
            dfs(setp, setpCount+1, str, end, bank);
            //当前层 数据 reverse
            setp.remove(str);
          }
       }
    }
}
// @lc code=end

