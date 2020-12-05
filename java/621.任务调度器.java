/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //时间复杂度 O(nlogn)
        //间隔时间为零
        if(n == 0) return tasks.length;
        
        // 存放 任务 计算相同任务数
        Map<Character,Integer> charMap = new HashMap<>();

        for(char c : tasks){
           charMap.put(c,charMap.getOrDefault(c, 0)+1);
        }
        //优先队列 贪心获取次数最多的任务
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->charMap.get(b) - charMap.get(a));

        maxHeap.addAll(charMap.keySet());
        //循环次数
        int totalCycles = 0;

        while(!maxHeap.isEmpty()){
          List<Character> current = new ArrayList<>();

          for(int i = 0; i < n+1; i++){
             if(!maxHeap.isEmpty()){
               Character c = maxHeap.remove();
               charMap.put(c,charMap.get(c) -1);
               current.add(c);
             }
          }

          for(Character c : current){
              if(charMap.get(c) > 0){
                  maxHeap.add(c);
              }
          }
          totalCycles += maxHeap.isEmpty() ? current.size() : n+1;
        }

        return totalCycles;

    }
}
// @lc code=end

