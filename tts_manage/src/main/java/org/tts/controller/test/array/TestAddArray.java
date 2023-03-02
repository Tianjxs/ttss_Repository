package org.tts.controller.test.array;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2023/02/10 13:28
 */
public class TestAddArray {

    public static void main(String[] args) {
        int[] arr =new int[]{1,2,3,4,5};

        int[] newArr =new int[6];

        for (int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        newArr[arr.length]=6;
        System.out.println(Arrays.toString(newArr));

        int a=1;
        int b=100;
        int c=(a+b)*b/2;
        System.out.println(c);
    }
}
