#include<iostream>
using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int len = nums.size();
    unordered_map<int ,int> shuzu;
    vector<int> a;
    for(int i=0;i<len;i++){
        int comple = target - nums[i];
        if (shuzu.find(comple)!= shuzu.end()) {
            a.push_back(shuzu[comple]);
            a.push_back(i);
            return a;
        }
        shuzu[nums[i]]=i;
    }
    return a;
    }
};

int main(){
   Solution s;
   int target= 0;
   vector<int>& nums = {2, 7, 11, 15};
   cout<<s.twoSum(nums,9)[0]<<endl;
   cout<<s.twoSum(nums,9)[1]<<endl;
}