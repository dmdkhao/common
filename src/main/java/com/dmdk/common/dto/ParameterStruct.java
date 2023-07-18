package com.dmdk.common.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ParameterStruct implements Serializable {

    private String type;

    private List<JSONObject> specs;


}
