package com.wode;

import java.util.Arrays;

/**
 * @author tao
 * 2023/12/7 10:40
 */
class Solution {

    public static void main(String[] args) {
        int[] nums  = new int[]{100,4,200,1,3,2};
        longestConsecutive(nums);
    }


    public static int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int temp = 0;
        //1、 数组从小到大排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] =  nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        Arrays.stream(nums).forEach(x ->{
            System.out.println(x);
        });
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            if (i + 1 < nums.length  && nums[i] + 1 == nums[i + 1]) {
                index++;
            }
            if (index >= res){
                res = index;
            }
        }
        return res;
    }
}
