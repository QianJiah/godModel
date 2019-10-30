package com.loong.base;

/**
 * author: Hao
 * date: 2019/10/9 9:15
 * description：被装饰类
 */
public class MakeClothes implements Clothes {

    @Override
    public void makeClothes() {
        System.out.println("制作一件衣服——");
    }
}
