package org.tts.controller.test.array;

import java.util.Arrays;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2023/02/10 13:33
 */
public class TestDelArray {

    public static void main(String[] args) {
        int[] arr=new int[]{6,5,4,3,2,1};
        int[] newArr =new int[arr.length-1];

        //删除第三个元素
        for (int i=0;i<arr.length-1;i++){

            if(i<3){
                newArr[i]=arr[i];
            }else{
                newArr[i]=arr[i+1];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
