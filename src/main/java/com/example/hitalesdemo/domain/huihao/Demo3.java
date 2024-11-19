package com.example.hitalesdemo.domain.huihao;

import com.alibaba.fastjson.JSONObject;

public class Demo3 {

    public static void main(String[] args) {
        String bodyString = "[\n" +
                "        {\n" +
                "            \"lab\": \"病例特点：\",\n" +
                "            \"value\": \"1. 老年男，急性起病，治疗史明确，病程较长。\\r\\n2. 患者于1月余前无明显诱因出现黑便，活动后气喘，偶有恶心、呕吐，为胃内容物，休息可缓解，未予重视；3天前家属发现患者精神淡漠，间断无法认人，交谈反应迟钝，四肢无力，走路摇摆，患者诉胸闷气促，伴头晕，视物模糊，休息后无好转。\\r\\n3. 查体：T：36.8℃ P：92次/分 R：21次/分 BP：138/71mmHg。贫血面容，神志淡漠，精神状态较差，双肺呼吸音低，双侧肺可闻及哮鸣音；腹平坦，无腹壁静脉曲张，腹部柔软，无压痛、反跳痛；Murphy氏征阴性，肾区无叩击痛，无移动性浊音；肠鸣音亢进，5次/分；四肢活动自如，双下肢无浮肿。\\r\\n4. 辅助检查：（2023-07-14 本院）【血常规(含CRP)】:全血C反应蛋白 16.15mg/L↑，白细胞计数 8.56x10^9/L，平均红细胞血红蛋白浓度 264g/L↓，红细胞计数 2.35已复x10^12/L↓，平均红细胞体积 69.4fL↓，平均红细胞血红蛋白含量 18.3pg↓，淋巴细胞 15.3%↓，单核细胞 10.0%，中性粒细胞 73.4%，血小板计数 392x10^9/L↑，血红蛋白 43已复g/L↓；【血气分析含电解质代谢物】:阴离子隙 21.10mmol/L↑，BB 38.80mmol/L↓，碱剩余 -4.80mmol/L↓，实际碳酸氢盐浓度 18.60mmol/L↓，乳酸 1.80mmol/L↑，二氧化碳分压 25.80mmHg↓，pH值 7.475↑，氧分压 93.70mmHg，有效氧饱和度 98.00%。\",\n" +
                "            \"sort\": 1\n" +
                "        }\n" +
                "    ]";
        JSONObject requestBody = JSONObject.parseObject(bodyString);
        System.out.println(requestBody);
    }
}
