package com.sww.genericity;

/**
 * 【类泛型】测试：
 * Object代表万能
 *
 * @param <T> 但是【泛型】是一种规范。
 */
public class MyArrayList<T> {

    private Object[] items = new Object[10];
    private int index = -1;

    public void add(T item) {
        this.items[++index] = item;
    }

    public void remove(T item) {
        if (index < 0) return;
        items[index--] = item;
    }

}
