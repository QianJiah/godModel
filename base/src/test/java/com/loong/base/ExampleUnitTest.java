package com.loong.base;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    /**
     * 装饰者模式：
     * 制作一件衣服——
     * 给衣服上颜色，增强色感
     * 给衣服绣花，增强美感
     * 制作完毕！
     */
    @Test
    public void decoratorTest() {
        //这个是被装饰的，即在此基础上增强功能
        Clothes clothes = new MakeClothes();

        //上色
        clothes = new ColorfulMakeClothes(clothes);

        //绣花
        clothes = new FlowerMakeClothes(clothes);

        //制作
        clothes.makeClothes();

        System.out.println("制作完毕！");

        InputStream inputStream;

        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[20]);

        bais.read();
    }
}