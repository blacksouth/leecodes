package algorithm;

import java.util.Arrays;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *

 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。

 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
     //   int i = removeElement.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        int i1 = removeElement.removeElementAnswer(new int[]{0,1,2,2,3,0,4,2,5}, 0);
        System.out.println(i1);

    }

    /**
     * 自己解题
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int temp=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==val){
                temp++;
                for (int j = i; j <nums.length-1 ; j++) {
                    nums[j]=nums[j+1];
                }
                i--;
            }
        }

        System.out.println(Arrays.toString(nums));
       return nums.length-temp;
    }

    /**
     * 题解
     * @param nums
     * @param val
     * @return
     */
    public int removeElementAnswer(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return len;
    }

}
