package org.tts.controller.test.array;

import java.util.Arrays;

/**
 * @Description : 插入排序
 * @Auther : Tianjx
 * @CreateTime : 2023/02/22 10:02
 */
public class TestInsertSort {
    /**
     * 1、从第一个元素开始，该元素可以认为已经被排序
     * 2、取出下一个元素，在已经排序的元素序列中 从后向前 扫描
     * 3、如果该元素(已排序)大于新元素，将该元素移到下一位置
     * 4、重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5、将新元素插入到该位置后，
     * 6、重复步骤2~5。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr =new int[]{5,2,3,7,9,1,6,4};
        System.out.println("=============================");

        for (int i = 1; i < arr.length; i++) {
          int insert=arr[i];
          while (i>0){
              if(arr[i-1]>insert){
                arr[i]=arr[i-1];
              }else{
                  arr[i]=insert;
                  break;
              }
              i--;
          }
          if(i==0){
              arr[0]=insert;
          }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ·上面讲的三种排序，冒泡、选择、插入由于均使用的了嵌套循环，并且循环基本上都要遍历所有的元素，所以用大O表示法都需要 O(N2) 时间级别。
     * 。但是三种排序还是有一些细微的区别(循环比较次数、交换次数)
     * 1、冒泡排序书写是最简单的，但是平均性能是没有选择排序和插入排序好的。因为它的循环比较次数和交换0次数都比较多
     * 2、选择排序循环比较的次数多，但是交换的次数少
     * 4、插入排序的交换次数多，但是循环比较的次数少
     */
}
