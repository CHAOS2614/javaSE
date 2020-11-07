package cn.edu.bjfu.collectionmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Chao Huaiyu
 * @date 2020/10/23
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("abc");
        collection.add(new Date());

        for(Object object : collection){
            System.out.println(object);
        }
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            Object object = iterator.next();
            if(object.equals("abc")){
                iterator.remove();
            }else {
                System.out.println(object);
            }
        }
    }
}
