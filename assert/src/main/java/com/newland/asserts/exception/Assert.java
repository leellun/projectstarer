package com.newland.asserts.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class Assert {
    /**
     * 断言对象不为空
     * obj 为空则抛异常
     * @param obj
     */
    public static void notNull(Object obj){
        if(obj == null){
            log.info("obj is null.....................");
            throw new RuntimeException();
        }
    }


    /**
     * 断言对象为空
     * 如果对象obj不为空，则抛出异常
     * @param object
     */
    public static void isNull(Object object) {
        if (object != null) {
            log.info("obj is not null......");
            throw new RuntimeException();
        }
    }

    /**
     * 断言表达式为真
     * 如果不为真，则抛出异常
     *
     * @param expression 是否成功
     */
    public static void isTrue(boolean expression) {
        if (!expression) {
            log.info("fail...............");
            throw new RuntimeException();
        }
    }

    /**
     * 断言两个对象不相等
     * 如果相等，则抛出异常
     * @param m1
     * @param m2
     */
    public static void notEquals(Object m1, Object m2) {
        if (m1.equals(m2)) {
            log.info("equals...............");
            throw new RuntimeException();
        }
    }

    /**
     * 断言两个对象相等
     * 如果不相等，则抛出异常
     * @param m1
     * @param m2
     */
    public static void equals(Object m1, Object m2) {
        if (!m1.equals(m2)) {
            log.info("not equals...............");
            throw new RuntimeException();
        }
    }

    /**
     * 断言参数不为空
     * 如果为空，则抛出异常
     * @param s
     */
    public static void notEmpty(String s) {
        if (StringUtils.isEmpty(s)) {
            log.info("is empty...............");
            throw new RuntimeException();
        }
    }
}
