package algorithm;

import java.util.Arrays;

/**
 * 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋houses 和供暖器heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 示例 1:
 *
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 示例 3：
 *
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *
 * 提示：
 *
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109

 */
public class Heater {


    public static void main(String[] args) {

    }

    public int findRadius(int[] houses, int[] heaters) {
        // 排序
        Arrays.sort(houses);
        Arrays.sort(heaters);

        // 双指针计算最大半径
        int res = 0;
        int i = 0;
        for (int house : houses) {
            for (i = 0; i < heaters.length - 1; i++) {
                if (Math.abs(heaters[i] - house) < Math.abs(heaters[i + 1] - house)) {  // 查找到当前房屋最近的暖器
                    break;
                }
            }
            // 比较 较大半径
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;


    }
}
