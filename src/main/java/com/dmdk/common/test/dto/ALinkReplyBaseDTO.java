package com.dmdk.common.test.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ALinkReplyBaseDTO {
    private String id;
    private Integer code;
    private JSONObject data;
}
