package com.example.hitalesdemo.domain.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

public class MapDBExample {

    public static void main(String[] args) {
        // 创建或打开数据库文件
        DB db = DBMaker.fileDB("example.db").make();

        // 创建或打开哈希表
        HTreeMap<String, String> map = (HTreeMap<String, String>) db.hashMap("exampleMap").keySerializer(Serializer.STRING).valueSerializer(Serializer.JAVA).createOrOpen();

        // 写入数据
        map.put("key1", "测试");
        map.put("key2", "value2");

        // 读取数据
        String value1 = map.get("key1");
        System.out.println("Key1: " + value1);

        // 删除数据
        map.remove("key2");

        // 关闭数据库
        db.close();
    }
}
