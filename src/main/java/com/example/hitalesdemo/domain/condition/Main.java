package com.example.hitalesdemo.domain.condition;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ExpressionMaEntity expressionMaEntity = new ExpressionMaEntity();
        expressionMaEntity.setStandardId("s");
        expressionMaEntity.setType(1);

        ArrayList<ExpressionMaEntity> expressionMaEntities = new ArrayList<>();
        expressionMaEntities.add(expressionMaEntity);


        Map<String, BitSet> collect = expressionMaEntities.stream()
                .filter(expressionma -> expressionma.getStandardId() != null && expressionma.getType() != null)
                .collect(Collectors.toMap(expressionma -> expressionma.getStandardId() + "_" + expressionma.getType(), s -> Optional.ofNullable(s.getBitSet()).orElse(new BitSet())));
        System.out.println(collect);
    }
}
