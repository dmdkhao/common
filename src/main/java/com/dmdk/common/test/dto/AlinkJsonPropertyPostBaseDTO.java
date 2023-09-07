package com.dmdk.common.test.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlinkJsonPropertyPostBaseDTO {
    private String id;
    private String version;
    private String method;
    private JSONObject params;
}
