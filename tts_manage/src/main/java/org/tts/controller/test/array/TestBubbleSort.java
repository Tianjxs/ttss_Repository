package org.tts.controller.test.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Description : 冒泡排序
 * @Auther : Tianjx
 * @CreateTime : 2023/02/21 17:40
 */
@Slf4j
public class TestBubbleSort {
    /**
     *  1、首先在未排序数组的首位开始,和后面相邻的数字进行比较, 如果前面比后面的大 则进行交换,
     *  2、接下来将第二个位置上的数字和后面相邻的数字进行比较,如果大那么则进行交换,直到将最大的数字交换到数组的尾部。
     *  3、然后再从排序的数组首位开始,重复前面两个步骤将最大的数据交换到未排序数组尾部, (对之前交换到数组最大的数字不进行比较了)
     * @param args
     */
    public static void main(String[] args) {
        int[] arr =new int[]{2,5,3,7,9,1,6,4};

        System.out.println("=============================");
        for (int i = 1; i <arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
