package com.dmdk.common.util;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    public static String findObjectByPath(String content, String path) {
        try {
            String[] split = path.split("\\.");
            JSONObject jsonObject = JSONObject.parseObject(content);
            JSONObject tempObject = jsonObject;
            String result = null;
            for (int i = 0; i < split.length; i++) {
                if (i < split.length-1) {
                    tempObject = tempObject.getJSONObject(split[i]);
                }else{
                    result = tempObject.getString(split[i]);
                }
                if (tempObject == null) {
                    System.out.println("查不到");
                    break;
                }
            }
            System.out.println(tempObject.toString());
            return result;
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String path = "aaa.bbb.ccc";
        String content = "{\"aaa\":{\"bbb\":{\"ccc\":\"battery\"}}}";

        String path1 = "method";
        String content1 = "{\"method\":\"battery\"}";

        String path2 = "method";
        String content2 = "{\"method\":2139}";

        String path3 = "method";
        String content3 = "{\"method\":\"battery.12396\"}";

        String path4 = "aaax.bbb";
        String content4 = "{\"aaa\":{\"bbb\":{\"ccc\":\"battery\"}}}";

        String path5 = "aaa.bbb.ccc.ddd";
        String content5 = "{\"aaa\":{\"bbb\":{\"ccc\":\"battery\"}}}";
        String eventId = findObjectByPath(content4, path4);
        System.out.println(eventId);
    }
}
