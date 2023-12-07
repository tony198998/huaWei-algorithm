package com.wode;

import java.util.*;

/**
 * @author tao
 * 2023/12/7 10:40
 */
class 数组 {

//    public static void main(String[] args) {
//        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
//        longestConsecutive(nums);
//    }


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
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        Arrays.stream(nums).forEach(x -> {
            System.out.println(x);
        });
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            if (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                index++;
            }
            if (index >= res) {
                res = index;
            }
        }
        return res;
    }

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


//    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2,3};
//        int k = 4;
//        rotate(nums, k);

//    }

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        //把数组放入List中
        if (k > length) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                arr.add(nums[i]);
            }

            for (int i = 0; i < length; i++) {
                nums[(i + k - length) % length] = arr.get(i);
            }
            Arrays.stream(nums).forEach(x -> {
                System.out.println(x);
            });

        } else {
            int beginIndex = length - k;


            List<Integer> sets = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (i >= beginIndex) {
                    sets.add(nums[i]);
                }
            }

            for (int i = 0; i < length; i++) {
                if (i < beginIndex) {
                    sets.add(nums[i]);
                }
            }
            Object[] objects = sets.stream().toArray();

            for (int i = 0; i < objects.length; i++) {
                nums[i] = (int) objects[i];
            }
            Arrays.stream(nums).forEach(x -> {
                System.out.println(x);
            });
        }
//
//        int n = nums.length;
//        int[] newArr = new int[n];
//        for (int i = 0; i < n; ++i) {
//            newArr[(i + k) % n] = nums[i];
//        }
//        System.arraycopy(newArr, 0, nums, 0, n);
//    }
    }

    public boolean canJump(int[] nums) {
        
    }


}
