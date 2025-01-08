package com.example.hitalesdemo.domain.condition;

import java.io.UnsupportedEncodingException;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = new byte[]{(byte) 0x90, (byte) 0x91, (byte) 0x13};
        String result = new String(bytes, "GBK");
        System.out.println(result);
    }
}
