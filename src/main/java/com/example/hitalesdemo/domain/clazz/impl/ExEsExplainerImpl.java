package com.example.hitalesdemo.domain.clazz.impl;

import com.example.hitalesdemo.domain.clazz.AbsEsExplainer;
import org.springframework.stereotype.Service;

@Service
public class ExEsExplainerImpl extends AbsEsExplainer<String> {

    @Override
    public void test(String name) {
        Class entityClass = getEntityClass();
        System.out.println(entityClass.getName());
    }
}
