package com.github.w4o.boot.sao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaoTest {


    @Test
    void switchExpression() {

        assertEquals("结果：1", Sao.switchExpression(1));
        assertEquals("结果：2", Sao.switchExpression(2));
        assertEquals("结果：?", Sao.switchExpression(3));
    }

    @Test
    void newInstanceOf() {
        assertEquals("不是字符串类型", Sao.newInstanceOf(1));
        assertEquals("字符串长度：3", Sao.newInstanceOf("abc"));
    }


    @Test
    void collectionOf() {
        Sao.collectionOf();
    }
}