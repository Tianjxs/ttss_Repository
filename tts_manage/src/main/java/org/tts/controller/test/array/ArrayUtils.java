package org.tts.controller.test.array;

import java.util.Arrays;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2023/02/10 13:57
 */
public class ArrayUtils {

    private static Object[] elements = new Object[0];;

    public ArrayUtils() {

    }

    public static void  size(){
        System.out.println(elements.length);
    }
    /**
     * 末尾添加元素
     * @param element
     */
    public static void add(Object element){
        Object[] newArr =new Object[elements.length+1];
        for(int i=0; i<elements.length;i++){
            newArr[i]=elements[i];
        }
        newArr[elements.length]=element;
        elements=newArr;
    }

    public static void show(){
        System.out.println(Arrays.toString(elements));
    }

    /**
     * 删除某个下标元素
     * @param index
     */
    public static void delete(int index){

        if(index<0 || index > elements.length-1){
            throw new RuntimeException("下标越界");
        }
        Object[] newArr =new Object[elements.length-1];

        for(int i=0; i< newArr.length;i++){
            if(i<index){
                newArr[i]=elements[i];
            }else{
                newArr[i]=elements[i+1];
            }
        }
        elements=newArr;
    }

    /**
     * 获取指定下边中的元素值
     * @param index
     * @return
     */
    public static Object get(int index){
        if(index<0 || index > elements.length-1){
            throw new RuntimeException("下标越界");
        }
        return elements[index];
    }

    /**
     * 插入一个元素到指定的位置
     * @param index
     * @param element
     */
    public static void insert(int index ,Object element){
        if(index<0 || index>elements.length){
            throw new RuntimeException("下标越界");
        }

        Object[] newArr=new Object[elements.length+1];
        for(int i=0; i<newArr.length; i++){
            if(i<index){
                newArr[i]=elements[i];
            }else if(i==index){
                newArr[i]=element;
            }else{
                newArr[i]=elements[i-1];
            }
        }
        elements=newArr;
    }

    /**
     * 查找某个元素的下标 用二分法进行
     * 使用从小到大排序的数组
     * @param targetElement
     * @return
     */
    public static int search(int targetElement){

        if(targetElement <(Integer) elements[0] || targetElement >(Integer) elements[elements.length-1]){
            throw new RuntimeException("目标值不在数组范围内,数据异常");
        }

        int begin =0;
        int end= elements.length-1;
        int half=(begin+end)/2;
        int index=-1 ;
        while (true){
            if(targetElement == (Integer) elements[half]){
                index=half;
                break;
            }else if(targetElement > (Integer) elements[half]){
                    begin=half+1;
            }else{
                end=half-1;
            }
            half=(begin+end)/2;
        }
        return index;
    }
}