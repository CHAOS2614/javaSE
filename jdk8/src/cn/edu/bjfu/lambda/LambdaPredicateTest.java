package cn.edu.bjfu.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Chao Huaiyu
 * @date 2020/11/2
 */
public class LambdaPredicateTest {

    @Test
    public void predicateTest() {
        List<String> list1 = new ArrayList<String>(6);
        list1.add("北京");
        list1.add("南京");
        list1.add("天津");
        list1.add("东京");
        list1.add("山西");
        list1.add("北林");

        List resultList = filterString(list1, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(resultList);

        System.out.println("----------Lambda方式----------");

        List resultList2 = filterString(list1,s -> s.contains("京"));
        System.out.println(resultList2);


    }

    /**
     * 根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
     * @param list 要过滤的集合
     * @param pre Predicate实例
     * @return 过滤之后的集合
     */
    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
