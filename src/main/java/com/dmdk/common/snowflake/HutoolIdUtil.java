package com.dmdk.common.snowflake;

import cn.hutool.core.util.IdUtil;

public class HutoolIdUtil {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long snowflakeNextId = IdUtil.getSnowflakeNextId();
        }

    }
}
