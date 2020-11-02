/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        //先排序 双指针遍历数组

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length,length2 = nums2.length;

        int []temp = new int[length1+length2];

        //两个数组指针 结果数组指针
        int index1 =0,index2 =0,index = 0;

        while(index1 < length1 && index2<length2){
              int n1 = nums1[index1],n2 = nums2[index2];
              if(n1 == n2){
                  //元素唯一
              if(index == 0 || n1!= temp[index -1]){
                temp[index++] = n1;
               }
               index1++;
               index2++;
             }else if(n1<n2){
                 index1++;
             }else{
                 //n1 > n2
                 index2++;
             }
        }
              
        return Arrays.copyOfRange(temp,0,index);
    }
}
// @lc code=end

