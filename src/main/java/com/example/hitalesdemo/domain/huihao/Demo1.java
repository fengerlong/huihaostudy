package com.example.hitalesdemo.domain.huihao;

public class Demo1 {

    public static void main(String[] args) {
        int a = 0;
        a = test(a);
        System.out.println(a);
        System.out.println(++a);

    }

    public static int test(int sort) {
        return ++sort;
    }
}
