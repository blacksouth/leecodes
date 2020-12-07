package algorithm;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]

 */

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0,0,1});
    }


    /**
     * 自己解法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
             int i = 0;
            while(i < nums.length){
                if(nums[i]==0){
                 for (int j = i; j <nums.length-1 ; j++) {
                        nums[j]=nums[j+1];
                     }
                    nums[nums.length-1]=0;
                }else {
                    i++;
                }
            }
        System.out.println(Arrays.toString(nums));

    }


}
