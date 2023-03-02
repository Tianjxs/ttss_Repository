package org.tts.controller.test.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Description : 选择排序
 * @Auther : Tianjx
 * @CreateTime : 2023/02/13 10:10
 */
@Slf4j
public class TestSelectSort {
    /**
     * 首先在未排序序列中找到最小(大)元素，存放到排序序列的起始位置·
     * 然后，再从剩余未排序元素中继续寻找最小(大)元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕
     *
     * 自身使用连个for循环 外层获取一个,对比内层for循环所有的数据 比较大(小) 第一次循环所有,后续每循环一次就减少一个,所以内循环要倒叙循环
     * 通过临时变量 保存某个位置上的值,然后将其位置上的值进行调换
     * 这样数组中第一个位置就是最大或者最小值,这样一次就可以排序出来了
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr =new int[]{2,5,3,7,9,1,6,4};

        System.out.println("=============================");
        for (int j = 0; j < arr.length; j++) {
            for (int i = arr.length-1; i>=j ; i--) {
               log.info("比较{},{}",arr[j],arr[i]);
                if(arr[j]< arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
           log.info("-------------------");
        }
        System.out.println(Arrays.toString(arr));

    }
}
