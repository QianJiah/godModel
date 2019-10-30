package com.loong.base;

/**
 * author: Hao
 * date: 2019/10/9 10:08
 * description: 给衣服上色
 */
public class ColorfulMakeClothes extends Decorator {

    public ColorfulMakeClothes(Clothes _clothes) {
        super(_clothes);
    }

    @Override
    public void makeClothes() {
        super.makeClothes();
        System.out.println("给衣服上颜色，增强色感");
    }
}
