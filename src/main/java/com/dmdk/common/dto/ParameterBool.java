package com.dmdk.common.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ParameterBool  {

    private Map<Boolean, String> mapping;

    private String type;


}
