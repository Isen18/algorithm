package com.isen.base.algorithm.math;

/**
 * 排列
 *
 * @author Isen
 * @date 2019/2/14 17:00
 * @since 1.0
 */
public class Permutation {
    public static void printArray(int[] array){
        for(int tmp : array){
            System.out.print(tmp);
        }

        System.out.println();
    }

    public static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    /**
     * 全排列
     * @param array
     */
    public static void allPermutation(int[] array, int k){
        if(k == array.length){
            printArray(array);
            return;
        }

        for(int i = 0; i < array.length; ++i){
            swap(array, k, i);
            allPermutation(array, k + 1);
            swap(array, k, i);
        }
    }

    public static boolean isSwap(int[] array, int x, int y){
        for(int i = x; i < y; i++){
            if(array[i] == array[y]){
                return false;
            }
        }

        return true;
    }

    /**
     * 全排列(去重)
     * @param array
     */
    public static void allPermutation2(int[] array, int k){
        if(k == array.length){
            printArray(array);
            return;
        }

        for(int i = 0; i < array.length; ++i){
            // FIXME isen 2019/2/14 有问题
            if(isSwap(array, k, i)){
                swap(array, k, i);
                allPermutation(array, k + 1);
                swap(array, k, i);
            }
        }
    }


    public static void main(String[] args) {
//        int[] array = {1, 2, 3};
//        allPermutation(array, 0);

//        int[] array2 = {1, 2, 2};
//        allPermutation2(array2, 0);
    }

}
