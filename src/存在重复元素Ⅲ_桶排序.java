import java.util.HashMap;
import java.util.Map;

/**
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得nums [i] 和nums [j]的差的绝对值小于等于 t ，
 * 且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *示例1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *

 */
public class 存在重复元素Ⅲ_桶排序 {


    public static void main(String[] args) {
        int[] arr={1,2,3,1};

        System.out.println(containsNearbyAlmostDuplicate(arr,3,0));

    }

    static long w;
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
     /*
            k --- index     1
            t ---- value    2147483647
        */


        if(nums.length == 0 || t < 0)        return false;
        //long ---id    long value
        HashMap<Long, Long> map = new HashMap<>();
        w = (long)t + 1;

        for(int i = 0; i < nums.length; i++)
        {
            if(i - k - 1 >= 0 && map.containsKey(getID(nums[i - k - 1])))
                map.remove(getID(nums[i - k - 1]));
            if(map.containsKey(getID(nums[i])))
                return true;
            if(map.containsKey(getID(nums[i]) - 1)
                    && Math.abs(map.get(getID(nums[i]) - 1) - (long)nums[i]) <= t)
                return true;
            if(map.containsKey(getID(nums[i]) + 1)
                    && Math.abs(map.get(getID(nums[i]) + 1) - (long)nums[i]) <= t)
                return true;
            map.put(getID(nums[i]), (long)nums[i]);
        }
        return false;

    }
    private static long getID(long num)
    {
        if(num >= 0)    return (long) num / w;
        else            return (long) (num - 1) / w - 1;
    }

}
