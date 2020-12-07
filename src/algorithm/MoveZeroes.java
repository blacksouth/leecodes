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
        moveZeroes.moveZeroes(new int[]{0,1,0,3,12});
    }
   /**
     * 自己解法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
       for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                for (int j = i; j < nums.length; j++) {
                    if(nums[j]!=0){
                        nums[i]=nums[j];
                        nums[j]=0;
                        break;
                    }
                }
            }
        }


    }


}
