/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

        for(int i :stones) queue.offer(i);
        
        while(queue.size()>1){
            int a = queue.poll();
            int b = queue.poll();
            if(a > b){
                queue.offer(a-b);
            }
        }

        return queue.isEmpty()? 0 :queue.poll();


    }
}
// @lc code=end

