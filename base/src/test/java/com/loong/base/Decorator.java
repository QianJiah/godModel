package com.loong.base;

/**
 * author: Hao
 * date: 2019/10/9 10:05
 * description:装饰者类
 */
public class Decorator implements Clothes {

    private Clothes clothes;
    public Decorator(Clothes _clothes) {
        this.clothes = _clothes;
    }

    @Override
    public void makeClothes() {
        clothes.makeClothes();
    }
}
