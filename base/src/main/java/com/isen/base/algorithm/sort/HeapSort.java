package com.isen.base.algorithm.sort;

/**
 * @author Isen
 * @date 2019/2/15 10:22
 * @since 1.0
 */
public class HeapSort {
    public static void shift(int[] array, int k, int end){
        int i = k;
        int j = i << 1;
        int tmp = array[k];
        while(j <= end){
            //j 指向最大的孩子
            if(j < end && array[j] < array[j + 1]){
                j++;
            }

            if(array[j] > tmp){
                array[i] = array[j];
                i = j;
                j = i << 1;
            }else {
                break;
            }
        }

        array[i] = tmp;
    }

    public static void sort(int[] array){
        //构造大根堆
        int end = array.length - 1;
        for(int i = end >> 1; i > 0; i--){
            shift(array, i, end);
        }

        //堆排序
        for(int i = end; i > 1; i--){
            int tmp = array[i];
            array[i] = array[1];
            array[1] = tmp;

            shift(array, 1, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {22, 2, 1, 1, 23, 2, 4};
        sort(array);
        System.out.println(array);
    }
}
