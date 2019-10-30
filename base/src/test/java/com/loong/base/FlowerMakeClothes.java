package com.loong.base;

/**
 * author: Hao
 * date: 2019/10/9 10:10
 * description: 给衣服绣花
 */
public class FlowerMakeClothes extends Decorator {

    public FlowerMakeClothes(Clothes _clothes) {
        super(_clothes);
    }

    @Override
    public void makeClothes() {
        super.makeClothes();
        System.out.println("给衣服绣花，增强美感");
    }
}
