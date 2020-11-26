import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0
 * 示例1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 */
public class 最大间距_桶排序 {

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,8 };
        System.out.println(maximumGapAnswer(nums));
       // System.out.println(maximumGap(nums));

    }

    /**
     * 教学做法
     */
    public static int maximumGapAnswer(int[] nums) {
        if(nums.length <= 1)        return 0;
        int n = nums.length;

        int max = -1, min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        if(max - min == 0)      return 0;   //1,1,1,1

        int[] bucketMin = new int[n-1];
        int[] bucketMax = new int[n-1];
        Arrays.fill(bucketMax, -1);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        //
        int interval = (int) Math.ceil((double)(max - min) / (n - 1));
        for(int i = 0; i < nums.length; i++)
        {
            int ID = (nums[i] - min) / interval;
            if(nums[i] == min || nums[i] == max)    continue;
            bucketMax[ID] = Math.max(bucketMax[ID], nums[i]);
            bucketMin[ID] = Math.min(bucketMin[ID], nums[i]);
        }

        int maxGap = 0; int previousMax = min;
        for(int i = 0; i < n - 1; i++)
        {
            if(bucketMax[i] == -1)     continue;
            maxGap = Math.max(bucketMin[i] - previousMax, maxGap);
            previousMax = bucketMax[i];
        }

        //1, 100000
        maxGap = Math.max(maxGap, max - previousMax);
        return maxGap;


    }

    /**
     * 自己做法
     * @param nums
     * @return
     */
    public static int maximumGap(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int maxNumber=0;
        for (int i = 0; i <nums.length ; i++) {
            if(i!=0){
                int gap=nums[i]-nums[i-1];
                if(gap>maxNumber){
                    maxNumber=gap;
                }
            }
        }
        return maxNumber;
    }
}
