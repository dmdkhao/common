package com.dmdk.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParameterEnum {
    private String type;
    private Map<String, String> mapping;
}
