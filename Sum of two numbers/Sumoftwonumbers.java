public class Sumoftwonumbers{
public static void main(String[] args) {
    int [] nums ={ 8, 90, 2, 7};
    int target = 9;
     System.out.println(twoSum(nums,target)[0]);
     System.out.println(twoSum(nums,target)[1]);
}

public static int[] twoSum(int[] nums, int target) {
    int[] a = new int[2];
    for(int i=0;i<nums.length-1;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i] + nums[j] == target){
                a[0]=i;
                a[1]=j;
                return a;
            }
        }
    }
    return a;
   }
}