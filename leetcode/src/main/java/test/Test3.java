package test;

public class Test3 {
    
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, 0, nums.length - 1, target);
        int last = findLast(nums, 0, nums.length - 1, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int s, int t, int target) {
        if (s > t) {
            return -1;
        }

        int mid = (t + s) >> 1;
        if (nums[mid] < target) {
            return findFirst(nums, mid + 1, t, target);
        } else if (nums[mid] > target) {
            return findFirst(nums, s, mid - 1, target);
        }

        if (mid == 0) {
            return 0;
        }

        if (nums[mid] != nums[mid - 1]) {
            return mid;
        }

        return -1;
    }

    private int findLast(int[] nums, int s, int t, int target) {
        if (s > t) {
            return -1;
        }

        int mid = (t + s) >> 1;
        if (nums[mid] < target) {
            return findLast(nums, mid + 1, t, target);
        } else if (nums[mid] > target) {
            return findLast(nums, s, mid - 1, target);
        }

        if (mid == nums.length - 1) {
            return nums.length - 1;
        }

        if (nums[mid] != nums[mid + 1]) {
            return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int nums[] = {5,7,7,8,8,10};
        int[] res = test3.searchRange(nums, 8);
        System.out.println(res);
    }
}