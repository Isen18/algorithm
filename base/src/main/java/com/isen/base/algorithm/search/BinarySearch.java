package com.isen.base.algorithm.search;

/**
 * @author Isen
 * @date 2019/2/15 11:26
 * @since 1.0
 */
public class BinarySearch {
    public static int search(int[] array, int start, int end, int k){
        if(start > end){
            return -1;
        }

        int mid = (end + start) >> 1;
        if(array[mid] == k){
            return mid;
        }

        if(array[mid] < k){
            return search(array, mid + 1, end, k);
        }

        return search(array, start, mid - 1, k);
    }

    public static int search(int[] array, int k){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int mid = (start + end) >> 1;
            if(array[mid] == k){
                return mid;
            }else if(array[mid] < k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 3, 4, 5, 6};
        int p = search(array, 0, array.length - 1, 2);
        System.out.println("p=" + p);

        p = search(array, 2);
        System.out.println("p=" + p);
    }
}
