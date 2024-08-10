package com.example.hitalesdemo.domain.clazz;

import org.springframework.data.util.ClassTypeInformation;

public class AbsEsExplainer<T> implements IESExplainer{

    private Class<T> tClass = null;

    public Class<T> getEntityClass() {
        if (tClass == null) {
            tClass = getParameterizedType();
        }
        return tClass;
    }

    @Override
    public void test(String name) {
        System.out.println("test");
    }


    private Class getParameterizedType() {
        Class<?> type = ClassTypeInformation.from(this.getClass()).getRequiredSuperTypeInformation(AbsEsExplainer.class)
                .getTypeArguments().get(0).getType();
        return type;
    }
}
