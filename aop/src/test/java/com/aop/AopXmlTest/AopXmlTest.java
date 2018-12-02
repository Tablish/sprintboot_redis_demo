package com.aop.AopXmlTest;

import com.aop.AopAnotation.BraveKnight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/11/3
 * @Modified By
 */
public class AopXmlTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        BraveKnight knight = (BraveKnight) ac.getBean("knight");
        knight.saying();
        knight.legends();

    }
}