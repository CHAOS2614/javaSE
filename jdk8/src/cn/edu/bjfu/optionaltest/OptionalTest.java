package cn.edu.bjfu.optionaltest;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Chao Huaiyu
 * @date 2020/11/3
 */
public class OptionalTest {

    /**
     * 可能会有空指针异常
     * @param boy 如果为空或者其中girl属性为空则报空指针异常
     */
    public String getGirlName1(Boy boy){
        return boy.getGirl().getName();
    }

    /**
     *老方法避免空指针异常
     */
    public String getGirlName2(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl!=null){
                return girl.getName();
            }
        }
        return null;
    }

    /**
     * orElse(T t1);如果当前Optional内部封装的t是非空的，则返回内部的t；
     * 否则返回orElse()方法中的参数t1；
     */
    public String getGirlName3(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("Anna", 12)));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("luis", 13));
        return girl1.getName();
    }

    @Test
    public void test1(){
        Boy boy = null;
        System.out.println(getGirlName3(boy));
        boy = new Boy(null);
        System.out.println(getGirlName3(boy));
        boy.setGirl(new Girl("yui",16));
        System.out.println(getGirlName3(boy));
    }
}
