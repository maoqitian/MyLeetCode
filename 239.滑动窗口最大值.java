import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {


        // 滑动窗口 思想为使用队列

        //方法一 暴力法 遍历每个窗口的最大值  时间复杂度 O(nk) n为数组中元素个数

        //if (nums.length * k == 0) return new int[0];

        //确定返回数组的大小
        // int [] output = new int[nums.length - k + 1];

        // for (int i = 0; i < nums.length - k + 1; i++) {
        //     int max = Integer.MIN_VALUE;
        //     for (int j = i; j < i+k; j++) {
        //         //变量窗口最大值
        //         max = Math.max(max, nums[j]); 
        //     }
        //     output[i]= max;
        // }
        // return output;

        
        //方法二 使用 队列 双端队列 LinkedList 存储数组下标

        int numlength = nums.length;
        int [] output = new int[numlength - k + 1];
        //存放数组下标双端队列
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            
            if(!linkedList.isEmpty() && linkedList.peek() < i-k+1){
                //当前值大于链表中的值
                linkedList.poll();
            }
            while(!linkedList.isEmpty() && nums[i] >= nums[linkedList.peekLast()]){
                    linkedList.pollLast();
            }
            //尾部加入
            linkedList.offer(i);
            if(i- k+1>=0){
                //存储最大值
             output[i - k+1] = nums[linkedList.peek()];
            }
        }
        return output;
    }
}
// @lc code=end

