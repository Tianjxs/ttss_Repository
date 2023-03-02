package org.tts.controller.test.array;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2023/02/10 14:11
 */
public class ArrayUtilsTest {

    public static void main(String[] args) {
        ArrayUtils.add(1);
        ArrayUtils.add(2);
        ArrayUtils.add(3);
        ArrayUtils.add(4);
        ArrayUtils.add(5);
        ArrayUtils.add(6);
        ArrayUtils.add(7);
        ArrayUtils.add(8);
        ArrayUtils.add(9);
        ArrayUtils.add(10);

        ArrayUtils.show();
        //ArrayUtils.size();
        //ArrayUtils.delete(4);
        //String o = (String)ArrayUtils.get(2);
        //System.out.println(o);
        //ArrayUtils.insert(5,1);
        //ArrayUtils.show();
        //ArrayUtils.size();

        int select = ArrayUtils.search(10);
        System.out.println(select);
    }
}
