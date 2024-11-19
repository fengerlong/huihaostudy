package com.example.hitalesdemo.domain.unicode;

public class UnicodeExample {

    public static void main(String[] args) {
        String str = "汉字";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int codePoint = Character.codePointAt(str, i);
            System.out.printf("字符: %c, 代码点: U+%04X%n", ch, codePoint);
        }
    }
}
