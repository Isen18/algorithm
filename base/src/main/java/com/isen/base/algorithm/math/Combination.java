package com.isen.base.algorithm.math;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Isen
 * @date 2019/2/15 11:45
 * @since 1.0
 */
public class Combination {

    public static void print(Set<Integer> set){
        set.forEach(tmp -> System.out.print(tmp + " "));
        System.out.println();
    }

    public static void combination(int[] array, int k, int m, Set<Integer> set){
        if(m == 0){
            print(set);
            return;
        }

        if(k >= array.length){
            return;
        }

        set.add(array[k]);
        combination(array, k + 1, m - 1, set);
        set.remove(array[k]);

        combination(array, k + 1, m, set);
    }

    public static void combination2(int[] array, int m){
        for(int i = 0; i < (1 << array.length); i++){
            if(numOfOne(i) == m){
                int k = 0;
                int j = i;
                while(j > 0){
                    if((j & 1) == 1){
                        System.out.print(array[k] + " ");
                    }
                    j = j >> 1;
                    k++;
                }
                System.out.println();
            }
        }
    }

    public static int numOfOne(int i){
        int count = 0;
        while(i != 0){
            i &= (i - 1);
            count++;
        }
        return count;
    }

    public static void combination(int[] array, int m){
        Set<Integer> set = new HashSet<>();
        combination(array, 0, m, set);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
//        combination(array, 2);

        combination2(array, 2);
    }
}
