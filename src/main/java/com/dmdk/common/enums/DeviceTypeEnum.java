package com.dmdk.common.enums;

import cn.hutool.core.comparator.CompareUtil;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * 类  名：cn.newgrand.dcs.common.openapi.device.enums.DeviceTypeEnum
 * 类描述：todo
 * 创建人：许豪
 * 创建时间：2021/6/11 11:38
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author 许豪
 * @version 1.0
 */
@Getter
public enum DeviceTypeEnum {

    /**
     * 环境监测
     */
    Dust("环境监测", 150001L, "01", DeviceTypeEnum.TYPE_CODE_DUST),
    /**
     * 塔吊
     */
    Crane("塔吊监测", 150002L, "02", DeviceTypeEnum.TYPE_CODE_CRANE),
    /**
     * 升降机
     */
    Lift("升降机监测", 150003L, "03", DeviceTypeEnum.TYPE_CODE_LIFT),
    /**
     * 卸料平台
     */
    Unloadplat("卸料平台监测", 150004L, "04", DeviceTypeEnum.TYPE_CODE_UNLOAD_PLAT),
    /**
     * 智能电表
     */
    Power("智能电表", 150005L, "05", DeviceTypeEnum.TYPE_CODE_POWER),
    /**
     * 智能水表
     */
    Water("智能水表", 150006L, "06", DeviceTypeEnum.TYPE_CODE_WATER),
    /**
     * 人员定位
     */
    Location("人员定位", 150007L, "07", DeviceTypeEnum.TYPE_CODE_LOCATION),
    /**
     * AI视频监控
     */
    AI("AI视频监控", 150008L, "08", DeviceTypeEnum.TYPE_CODE_AI),
    /**
     * 视频监控
     */
    Video("视频监控", 150009L, "09", DeviceTypeEnum.TYPE_CODE_VIDEO),
    /**
     * 危大工程监测
     */
    DangerousProject("危大工程监测", 150010L, "10", DeviceTypeEnum.TYPE_CODE_DANGEROUS_PROJECT),
    /**
     * 标养室监测
     */
    Curing("标养室监测", 150011L, "11", DeviceTypeEnum.TYPE_CODE_CURING),
    /**
     * 临边防护监测
     */
    Edge("临边防护监测", 150012L, "12", DeviceTypeEnum.TYPE_CODE_EDGE),
    /**
     * 混凝土测温监测
     */
    Concrete("混凝土测温监测", 150013L, "13", DeviceTypeEnum.TYPE_CODE_CONCRETE),
    /**
     * 身体状态监测
     */
    Physical("身体状态监测", 150014L, "14", DeviceTypeEnum.TYPE_CODE_PHYSICAL),
    /**
     * 智能安全帽
     */
    SafetyHat("智能安全帽", 150015L, "15", DeviceTypeEnum.TYPE_CODE_SAFETY_HAT),
    /**
     * 有毒气体监测
     */
    Toxic("有毒气体监测", 150016L, "16", DeviceTypeEnum.TYPE_CODE_TOXIC),
    /**
     * 气象监测
     */
    Weather("气象监测", 150017L, "17", DeviceTypeEnum.TYPE_CODE_WEATHER),
    /**
     * 烟感器监测
     */
    Smog("烟感器检测", 150018L, "18", DeviceTypeEnum.TYPE_CODE_SMOG),
    /**
     * 智能配电箱监测
     */
    PowerMonitor("智能配电箱监测", 150019L, "19", DeviceTypeEnum.TYPE_CODE_POWER_MONITOR),
    /**
     * 智能回弹仪监测
     */
    Rebound("智能回弹仪监测", 150020L, "20", DeviceTypeEnum.TYPE_CODE_REBOUND),
    /**
     * 机械宝-推送实时数据
     */
    MechanicalTreasure("机械宝", 150021L, "21", DeviceTypeEnum.TYPE_CODE_Mechanical_Treasure),
    /**
     * 实测实量机器人
     */
    SCSLRobot("实测实量机器人", 150022L, "22", DeviceTypeEnum.TYPE_CODE_SCSL_ROBOT),
    /**
     * 龙门吊（单车双钩）
     */
    GantryCrane12("龙门吊（单车双钩）监测", 150023L, "23", DeviceTypeEnum.TYPE_CODE_GANTRY_CRANE12),
    /**
     * 龙门吊（双车单钩）
     */
    GantryCrane21("龙门吊（双车单钩）监测", 150024L, "24", DeviceTypeEnum.TYPE_CODE_GANTRY_CRANE21),
    /**
     * 架桥机
     */
    BridgeErect("架桥机监测", 150025L, "25", DeviceTypeEnum.TYPE_CODE_BRIDGE_ERECT),
    /**
     * 污水监测
     */
    Sewage("污水监测", 150026L, "26", DeviceTypeEnum.TYPE_CODE_SEWAGE),
    /**
     * 强电智能空开
     */
    CircuitBreaker("强电智能空开", 150027L, "27", DeviceTypeEnum.TYPE_CODE_CIRCUIT_BREAKER),
    /**
     * 空调
     */
    InfraredAirConditioners("空调", 150028L, "28", DeviceTypeEnum.TYPE_CODE_INFRARED_AIR_CONDITIONERS),
    /**
     * 人体传感器
     */
    PersonDetect("人体传感器", 150029L, "29", DeviceTypeEnum.TYPE_CODE_PERSON_DETECT),
    /**
     * 开关
     */
    Switch("开关", 150030L, "30", DeviceTypeEnum.TYPE_CODE_SWITCH),
    /**
     * 灯带
     */
    Belt("灯带控制器", 150031L, "31", DeviceTypeEnum.TYPE_CODE_BELT),
    /**
     * 智能广播
     */
    Radio("智能广播", 150032L, "32", DeviceTypeEnum.TYPE_CODE_RADIO),
    /**
     * 温湿度万能遥控器（红外网关）
     */
    InfraredGateway("温湿度万能遥控器（红外网关）", 150033L, "33", DeviceTypeEnum.TYPE_CODE_INFRARED_GATEWAY),
    /**
     * 吊篮监测
     */
    Basket("吊篮监测", 150034L, "34", DeviceTypeEnum.TYPE_CODE_BASKET),
    /**
     * 弱电智能空开
     */
    WeakCurrentCircuitBreaker("弱电智能空开", 150035L, "35", DeviceTypeEnum.TYPE_CODE_WEAK_CURRENT_CIRCUIT_BREAKER),
    /**
     * 隧道-有毒气体监测
     */
    TunnelToxic("隧道-有毒气体监测", 150036L, "36", DeviceTypeEnum.TYPE_CODE_Tunnel_Toxic),
    /**
     * 喷淋
     */
    Spray("喷淋", 150037L, "37", DeviceTypeEnum.TYPE_CODE_SPRAY)
    ;

    public static final String TYPE_CODE_DUST = "Dust";
    public static final String TYPE_CODE_CRANE = "Crane";
    public static final String TYPE_CODE_LIFT = "Lift";
    public static final String TYPE_CODE_UNLOAD_PLAT = "Unloadplat";
    public static final String TYPE_CODE_POWER = "Power";
    public static final String TYPE_CODE_CIRCUIT_BREAKER = "circuitBreaker";
    public static final String TYPE_CODE_WEAK_CURRENT_CIRCUIT_BREAKER = "weakCurrentCircuitBreaker";

    public static final String TYPE_CODE_INFRARED_GATEWAY = "infraredGateway";
    public static final String TYPE_CODE_INFRARED_AIR_CONDITIONERS = "infraredAirConditioners";
    public static final String TYPE_CODE_PERSON_DETECT = "personDetect";
    public static final String TYPE_CODE_SWITCH = "switch";
    public static final String TYPE_CODE_BELT = "belt";
    public static final String TYPE_CODE_WATER = "Water";
    public static final String TYPE_CODE_LOCATION = "Location";
    public static final String TYPE_CODE_AI = "AI";
    public static final String TYPE_CODE_VIDEO = "Video";
    public static final String TYPE_CODE_DANGEROUS_PROJECT = "DangerousProject";
    public static final String TYPE_CODE_CURING = "Curing";
    public static final String TYPE_CODE_EDGE = "Edge";
    public static final String TYPE_CODE_CONCRETE = "Concrete";
    public static final String TYPE_CODE_PHYSICAL = "Physical";
    public static final String TYPE_CODE_SAFETY_HAT = "SafetyHat";
    public static final String TYPE_CODE_TOXIC = "Toxic";
    public static final String TYPE_CODE_WEATHER = "Weather";
    public static final String TYPE_CODE_SMOG = "Smog";
    public static final String TYPE_CODE_POWER_MONITOR = "PowerMonitor";
    public static final String TYPE_CODE_REBOUND = "Rebound";
    public static final String TYPE_CODE_Mechanical_Treasure = "MechanicalTreasure";
    public static final String TYPE_CODE_SCSL_ROBOT = "SCSLRobot";
    public static final String TYPE_CODE_GANTRY_CRANE12 = "GantryCrane12";
    public static final String TYPE_CODE_GANTRY_CRANE21 = "GantryCrane21";
    public static final String TYPE_CODE_BRIDGE_ERECT = "BridgeErect";
    public static final String TYPE_CODE_SEWAGE = "Sewage";
    public static final String TYPE_CODE_RADIO = "Radio";
    public static final String TYPE_CODE_BASKET = "Basket";
    public static final String TYPE_CODE_Tunnel_Toxic = "TunnelToxic";
    public static final String TYPE_CODE_SPRAY = "Spray";

    public static final String TYPE_CODE_Lamp_Strip = "LampStrip";


    private final String typeName;
    /**
     * fg_simple_data表`c_type`='device_type'记录的phid字段值
     */
    private final Long id;
    private final String code;
    private final String typeCode;

    DeviceTypeEnum(String typeName, Long id, String code, String typeCode) {
        this.typeName = typeName;
        this.id = id;
        this.code = code;
        this.typeCode = typeCode;
    }

    public static Long getIdByCode(String code) {
        for (DeviceTypeEnum ele : values()) {
            if (ele.getCode().equalsIgnoreCase(code)) {
                return ele.getId();
            }
        }
        return null;
    }

    public static Long getIdByTypeCode(String code) {
        for (DeviceTypeEnum ele : values()) {
            if (ele.getTypeCode().equalsIgnoreCase(code)) {
                return ele.getId();
            }
        }
        return null;
    }


    public static DeviceTypeEnum getEnumByCode(String code) {
        for (DeviceTypeEnum ele : values()) {
            if (ele.getCode().equalsIgnoreCase(code)) {
                return ele;
            }
        }
        return null;
    }

    public static String getNameById(String id) {
        for (DeviceTypeEnum ele : values()) {
            if (ele.getId().equals(Long.valueOf(id))) {
                return ele.name();
            }
        }
        return null;
    }

    public static String getTypeNameById(Long id) {
        for (DeviceTypeEnum ele : values()) {
            if (ele.getId().equals(id)) {
                return ele.getTypeName();
            }
        }
        return null;
    }


    public static String getTypeCodeById(Long id) {
        for (DeviceTypeEnum ele : values()) {
            if (ele.getId().equals(id)) {
                return ele.getTypeCode();
            }
        }
        return null;
    }

    /**
     * 获取运维平台设备类型
     *
     * @param id
     * @return
     */
    public static String getOPMTypeCodeById(Long id) {

        if (Toxic.getId().equals(id) || Weather.getId().equals(id)) {
            return TYPE_CODE_DUST;
        }

        for (DeviceTypeEnum ele : values()) {
            if (ele.getId().equals(id)) {
                return ele.getTypeCode();
            }
        }
        return null;
    }

    /**
     * 根据监测类型获取环境设备类型
     *
     * @param toxicFlag 0-环境监测，1-毒气检测，2-气象监测
     * @return
     */
    public static String getTypeCodeByToxicFlag(Integer toxicFlag) {

        if (CompareUtil.compare(toxicFlag, 0, false) == 0) {
            return TYPE_CODE_DUST;
        } else if (CompareUtil.compare(toxicFlag, 1, false) == 0) {
            return TYPE_CODE_TOXIC;
        } else if (CompareUtil.compare(toxicFlag, 2, false) == 0) {
            return TYPE_CODE_WEATHER;
        }
        return null;
    }

    public static DeviceTypeEnum getEnumByTypeCode(String typeCode) {
        for (DeviceTypeEnum ele : values()) {
            if (ele.getTypeCode().equalsIgnoreCase(typeCode)) {
                return ele;
            }
        }
        return null;
    }

    public static List<Long> getIdList() {
        List<Long> list = Lists.newLinkedList();
        for (DeviceTypeEnum ele : values()) {
            list.add(ele.getId());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getEnumByTypeCode("unloadplat").getId());
    }

}

