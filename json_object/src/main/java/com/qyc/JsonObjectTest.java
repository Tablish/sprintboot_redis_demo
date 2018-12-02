package com.qyc;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/10
 * @Modified By
 */
public class JsonObjectTest {

    public static void jsonToJava() {
        System.out.println("jsonToJava:");
        JSONObject jsonObject = new JSONObject();
        String jsonStr = "{\"password\":\"123456\",\"username\":\"张三\"}";
        JSONObject object = jsonObject.fromObject(jsonStr);
        System.out.println(" "+object.get("password"));
        System.out.println(" "+object.get("username"));
    }

    public static void javaToJson() {
        System.out.println("javaToJson:");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","qianyongchao");
        jsonObject.put("age",24);
        System.out.println(jsonObject.toString());

    }

    public static void jsonToXml() {
        System.out.println("jsonToXml:");
        JSONObject jsonObject = new JSONObject();
        String jsonStr = "{\"password\":\"123456\",\"username\":\"张三\"}";
        JSONObject object = jsonObject.fromObject(jsonStr);
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setRootName("haha");
        xmlSerializer.setTypeHintsEnabled(false);

        String write = xmlSerializer.write(object);
        System.out.println(write);


    }


    public static void main(String[] args) {
        //jsonToJava();
        //javaToJson();
        jsonToXml();
    }
}
