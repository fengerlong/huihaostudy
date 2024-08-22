package com.example.hitalesdemo.domain.regular;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        processText("[aaaa<2.912E+02kkjduu]");
    }

    // 处理输入文本，提取科学计数法部分并格式化
    public static void processText(String text) {
        // 正则表达式模式
        String patternStr = "(<=|>=|<|>|=)\\s*([0-9]+(\\.[0-9]+)?[eE][+]?[0-9]+)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            // 提取符号和科学计数法部分
            String symbol = matcher.group(1);
            String scientificStr = matcher.group(2);

            // 转换科学计数法为 BigDecimal
            BigDecimal decimalValue = new BigDecimal(scientificStr);
            // 格式化 BigDecimal
            String formattedValue = formatBigDecimal(decimalValue);
            System.out.println(symbol2range(symbol,formattedValue));
        } else {
            System.out.println("No match found.");
        }
    }

    // 格式化 BigDecimal 为字符串，保留小数点后的非零数字
    private static String formatBigDecimal(BigDecimal value) {
        // 去除尾部零并获取不使用科学计数法表示的字符串
        String valueStr = value.stripTrailingZeros().toPlainString();
        // 移除尾部多余的零和小数点
        if (valueStr.indexOf('.') > -1 && valueStr.endsWith("0")) {
            return valueStr.replaceAll("\\.0*$", ""); // 移除尾部的 .0
        }
        return valueStr;
    }

    private static String symbol2range(String symbol, String val) {
        if ("<=".equals(symbol)) {
            return String.format("[0,%s]", val);
        } else if (">=".equals(symbol)) {
            return String.format("[%s,∞)", val);
        } else if ("<".equals(symbol)) {
            return String.format("[0,%s)", val);
        } else if (">".equals(symbol)) {
            return String.format("(%s,∞)", val);
        } else if ("=".equals(symbol)) {
            return val;
        }
        return "";
    }
}
