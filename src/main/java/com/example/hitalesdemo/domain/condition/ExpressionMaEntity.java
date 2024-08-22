package com.example.hitalesdemo.domain.condition;

import lombok.Data;

import java.util.BitSet;

@Data
public class ExpressionMaEntity {

    private String standardId;

    private Integer type;

    private BitSet bitSet;

    private String name;

    public void setBitSet(BitSet bitSet) {
        if(bitSet != null){
            //强制转成bitset，防止序列化成子类，子类做更改后serialVersionUID不一致
            this.bitSet = BitSet.valueOf(bitSet.toByteArray());
        }
    }
}
