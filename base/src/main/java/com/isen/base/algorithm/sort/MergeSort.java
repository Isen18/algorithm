package com.isen.base.algorithm.sort;

/**
 * @author Isen
 * @date 2019/2/15 10:49
 * @since 1.0
 */
public class MergeSort {
    public static void merge(int[] array, int low, int mid ,int high){
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[high - low + 1];
        while(i <= mid && j <= high){
            if(array[i] < array[j]){
                tmp[k++] = array[i++];
            }else {
                tmp[k++] = array[j++];
            }
        }

        while(i <= mid){
            tmp[k++] = array[i++];
        }

        while(j <= high){
            tmp[k++] = array[j++];
        }

        for(i = 0; i < tmp.length; i++){
            array[low + i] = tmp[i];
        }
    }

    public static void mergePass(int[] array, int len){
        int i = 0;
        //归并两个相邻的表
        for(; i + len * 2 - 1 < array.length; i = i + 2 * len){
            merge(array, i, i + len - 1, i + 2 * len -1);
        }

        //归并余下的两个表
        if(i + len - 1 < array.length){
            merge(array, i, i + len - 1, array.length - 1);
        }
    }


    public static void sort(int[] array){
        for(int len = 1; len < array.length; len = len << 1){
            mergePass(array, len);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 1, 1, 23, 2, 4};
        sort(array);
        System.out.println(array);
    }
}
