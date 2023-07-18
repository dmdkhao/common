package com.dmdk.common.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dmdk.common.dto.ParameterBool;
import com.dmdk.common.dto.ParameterEnum;
import com.dmdk.common.dto.ParameterStruct;

public class Temp {

    public static void main(String[] args) throws Exception {

        //dosomething
        //dosomething
        //dosomething

    }

    private static void jsonTest() {
        String jsonString = "{\"type\":\"STRUCT\",\"specs\":[{\"id\":\"stringid\",\"name\":\"stringid\",\"dataType\":{\"type\":\"STRING\",\"max\":8892}},{\"id\":\"boolid\",\"name\":\"boolid\",\"dataType\":{\"type\":\"BOOL\",\"mapping\":{\"0\":\"jk\",\"1\":\"ol\"}}}]}";
        final JSONObject jsonObject = JSONObject.parseObject(jsonString);
        final JSONArray specs = jsonObject.getJSONArray("specs");
        for (Object o : specs) {
            JSONObject o1 = (JSONObject) o;
            System.out.println(o1);

        }

        System.out.println(jsonObject);
    }

    private static void paramBoolTest() {
        String jsonString = "{\"type\":\"bool\",\"mapping\":{\"0\":\"关\",\"1\":\"开\"}}";
        final ParameterBool parameterBool = JSONObject.parseObject(jsonString, ParameterBool.class);
        System.out.println(parameterBool);
    }

    private static void paramEnumTest() {
        String jsonString = "{\"type\":\"enum\",\"mapping\":{\"0\":\"Red\",\"1\":\"Green\",\"2\":\"Blue\"}}";
        ParameterEnum parameterEnum = JSONObject.parseObject(jsonString, ParameterEnum.class);
        System.out.println(parameterEnum);
    }

}
