package cn.edu.bjfu.collectionmap.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型的使用
 *
 * @author Chao Huaiyu
 * @date 2020/10/25
 */
public class GenericTest {
    @Test
    public void genericTest() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(34);
        list.add(45);
        list.add(21);

        //list.add("int");编译时会进行类型检查，保证数据的安全；

        for(Integer score : list){
            System.out.println(score);
        }

        Iterator<Integer> integerIterator = list.iterator();
        while(integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

    }



}
