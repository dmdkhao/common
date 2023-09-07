package com.dmdk.common.test;

import com.alibaba.fastjson.JSONObject;
import com.dmdk.common.test.dto.ALinkReplyBaseDTO;
import com.dmdk.common.test.dto.AlinkJsonPropertyPostBaseDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
//        matchService();
//        matchProperty();
//        alinkPropertyConvert();
        String s = "+/+/+/";
        final String replace = s.replace("+", "[^/]+");
        System.out.println(replace);

    }

    public static boolean alinkReplyConvert() {
        String data = "{\n" +
                "    \"id\": \"3536123\",\n" +
                "    \"code\": 200,\n" +
                "    \"data\": {}\n" +
                "}";
        ALinkReplyBaseDTO alinkJsonPropertyPostBaseDTO = JSONObject.parseObject(data, ALinkReplyBaseDTO.class);
        System.out.println("ok");
        return true;
    }

    public static boolean alinkPropertyConvert() {
        String data = "{\"id\":\"9\",\"version\":\"1.0\",\"params\":{\"version\":{\"soft\":\"0.0.4.0\",\"hard\":\"0.0.0.1\"},\"sim\":{\"id\":\"12223335555556666\"}},\"method\":\"thing.event.property.post\"}";
        AlinkJsonPropertyPostBaseDTO alinkJsonPropertyPostBaseDTO = JSONObject.parseObject(data, AlinkJsonPropertyPostBaseDTO.class);
        System.out.println("ok");
        return true;
    }

    public static boolean matchService() {
        String template = "/sys/{productKey}/{deviceName}/thing/service/{tsl.service.identifier}";
        String topic = "/sys/a15qe5DbEeM/a15qe5DbEeM-01/thing/service/ktOnOff/123";

        String regex = template.replaceAll("\\{[^}]+\\}", "[^/]+");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(topic);
        boolean result = matcher.matches();
        return result;
    }

    public static boolean matchProperty() {
        String regex = "/sys/[^/]+/[^/]+/thing/event/property/post";
        String topic = "/sys/a15qe5DbEeM/serviceTestDevice02/thing/service/property/set";

//        String regex = template.replaceAll("\\{[^}]+\\}", "[^/]+");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(topic);
        boolean result = matcher.matches();
        return result;
    }


}
