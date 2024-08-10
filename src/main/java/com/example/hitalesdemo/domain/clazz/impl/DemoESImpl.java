package com.example.hitalesdemo.domain.clazz.impl;

import com.example.hitalesdemo.domain.clazz.AbsEsExplainer;
import org.springframework.stereotype.Service;

@Service
public class DemoESImpl extends AbsEsExplainer<Integer> {

    @Override
    public void test(String name) {
        Class entityClass = getEntityClass();
        System.out.println(entityClass.getName());
    }
}
