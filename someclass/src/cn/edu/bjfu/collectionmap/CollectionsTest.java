package cn.edu.bjfu.collectionmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections：操作Collection和Map的工具类
 * @author Chao Huaiyu
 * @date 2020/10/25
 */
public class CollectionsTest {

    @Test
    public void collectionsMethodTest(){
        //reverse()反转
        //shuffle()随机排序

        //copy()
        //报异常：
        //List Dest = new ArrayList();
        //Collections.copy(dest,list);dest的大小为0，不能复制
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(234);
        list.add(345);
        List<Integer> dest = Arrays.asList(new Integer[list.size()]);
        Collections.copy(dest,list);
    }
}
