import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 *
 * 列子
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums={3,2,4};
        int target=6;
        System.out.println(Arrays.toString( twoSum(nums,target)));
        System.out.println(Arrays.toString( twoSumAnswer(nums,target)));
    }

    /**
     * 自己的做法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target && i!=j){
                    ints[0]=i;
                    ints[1]=j;
                    return ints ;
                    //改善
                    //return new int[]int{i,j};
                }
            }
        }
        return null;
     }

    /**
     * 教学方法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumAnswer(int[] nums, int target) {
        int length = nums.length;
        //设置长度为nums.length-1的原因是因为最后一个数不用放进去
        HashMap<Integer, Integer> map = new HashMap<>(length - 1);
        for (int i = 0; i < length; i++) {
                if (map.containsKey(target-nums[i])){
                    return new int[]{i,map.get(target-nums[i])};
                }
                map.put(nums[i],i);
        }
        return null;
    }
}
