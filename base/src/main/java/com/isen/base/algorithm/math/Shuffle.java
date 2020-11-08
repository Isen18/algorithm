package com.isen.base.algorithm.math;

import java.util.Random;

/**
 * @author Isen
 * @date 2020/5/25 21:56
 * @since 1.0
 */
public class Shuffle {
    int[] originArr;

    public int[] shuffle(int[] arr) {
        this.originArr = arr;
        Random random = new Random();
        int [] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        for (int i = newArr.length - 1; i > 0; i--) {
            int idx = random.nextInt(i + 1);
            int tmp = newArr[i];
            newArr[i] = newArr[idx];
            newArr[idx] = tmp;
        }

        return newArr;
    }

    public int[] reset() {
        return originArr;
    }
 }
