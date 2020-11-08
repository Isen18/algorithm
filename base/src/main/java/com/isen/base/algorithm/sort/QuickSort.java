package com.isen.base.algorithm.sort;

import java.util.Random;

/**
 * @author Isen
 * @date 2019/2/13 22:37
 * @since 1.0
 */
public class QuickSort {
    public static void sort(int[] array, int start, int end){
        if(array.length == 0 || start >= end){
            return ;
        }

        int i = start;
        int j = end;
        int base = array[start];
        while(i < j){
            while(i < j && array[j] >= base){
                j--;
            }

            array[i] = array[j];
            while(i < j && array[i] < base){
                i++;
            }

            array[j] = array[i];
        }

        array[i] = base;
        sort(array, start, i);
        sort(array, i + 1, end);
    }

    public static int randomIndex(int start, int end){
        // XXX isen 2019/2/14改为随机
//        return new Random().nextInt(end - start + 1) + start;
        return start;
    }

    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static int partition(int[] array, int start, int end){
        int index = randomIndex(start, end);
        swap(array, index, start);
        int i = start;
        int j = end;
        int base = array[start];
        while(i < j){
            while(i < j && array[j] >= base){
                j--;
            }

            array[i] = array[j];
            while(i < j && array[i] < base){
                i++;
            }

            array[j] = array[i];
        }

        array[i] = base;
        return i;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 1, 23, 2, 4};
        QuickSort.sort(array, 0, array.length - 1);
        System.out.println(array);
    }
}
