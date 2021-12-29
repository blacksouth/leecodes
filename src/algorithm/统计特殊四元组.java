package algorithm;

import java.util.*;

/**
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * <p>
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 *  
 * <p>
 * 提示：
 * <p>
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-special-quadruplets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 统计特殊四元组 {


    public static void main(String[] args) {
        int[] aa = {1,1,1,3,5};
        System.out.println(countQuadrupletsTwo(aa));
    }


    public static int countQuadrupletsTwo(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int b = n - 3; b >= 1; --b) {
            for (int d = b + 2; d < n; ++d) {
                cnt.put(nums[d] - nums[b + 1], cnt.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; ++a) {
                ans += cnt.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return ans;
    }

    public static int countQuadrupletsThree(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int c = n - 2; c >= 2; --c) {
            cnt.put(nums[c + 1], cnt.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c; ++a) {
                for (int b = a + 1; b < c; ++b) {
                    ans += cnt.getOrDefault(nums[a] + nums[b] + nums[c], 0);
                }
            }
        }
        return ans;
    }



    public static int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int two = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    int three = nums[k];
                    for (int l = k+1; l < nums.length; l++) {
                        int four = nums[l];
                        if (four == one + two + three) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
