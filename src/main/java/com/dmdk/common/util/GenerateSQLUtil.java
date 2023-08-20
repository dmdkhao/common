package com.dmdk.common.util;

import com.dmdk.common.enums.DeviceBrandEnum;
import com.dmdk.common.enums.DeviceTypeEnum;

/**
 * 类  名：com.dmdk.common.util.GenerateSQLUtil
 * 类描述：小帮手-用于生成sql
 * 创建人：张皓
 * 创建时间：2023/8/10 10:57
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @Author zhanghao
 * @Date 2023/8/10 10:57
 * @Version 1.0
 */
public class GenerateSQLUtil {

    public static String genProductCategorySQL() {
        String insert = "INSERT INTO simple_data (id, `type`, code, name, pid, default_flag, created_time, modify_time, deleted) VALUES ";
        String template = " (%d, \"%s\", \"%s\", \"%s\", NULL, NULL, %d, %d, 0),";
        long timeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(insert);
        for (DeviceTypeEnum deviceTypeEnum : DeviceTypeEnum.values()) {
            String sql = String.format(template, deviceTypeEnum.getId(), "product_category", deviceTypeEnum.getCode(), deviceTypeEnum.getTypeName(), timeMillis, timeMillis);
            stringBuilder.append(sql);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String genProductBrandSQL() {
        String insert = "INSERT INTO simple_data (id, `type`, code, name, pid, default_flag, created_time, modify_time, deleted) VALUES ";
        String template = " (%d, \"%s\", \"%s\", \"%s\", NULL, NULL, %d, %d, 0),";
        long timeMillis = System.currentTimeMillis();
        int id = 160001;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(insert);
        for (DeviceBrandEnum deviceBrandEnum : DeviceBrandEnum.values()) {
            String sql = String.format(template, id, "product_brand", deviceBrandEnum.getBrandCode(), deviceBrandEnum.getBrandName(), timeMillis, timeMillis);
            stringBuilder.append(sql);
            stringBuilder.append("\n");
            id ++;
        }
        return stringBuilder.toString();
    }
}
