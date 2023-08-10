package com.dmdk.common.enums;

import lombok.Getter;

/**
 * 类  名：cn.newgrand.dcs.common.openapi.device.enums.DeviceBrandEnum
 * 类描述：设备品牌
 * 创建人：许豪
 * 创建时间：2021/10/21 20:55
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author 许豪
 * @version 1.0
 */
@Getter
public enum DeviceBrandEnum {

    /**
     * 携稳
     */
    XieWen(1L, "携稳", DeviceBrandEnum.BRAND_CODE_XIEWEN),
    /**
     * 星云网格
     */
    XYWG(2L, "星云网格", DeviceBrandEnum.BRAND_CODE_XYWG),
    /**
     * 海康威视
     */
    Hikvision(3L, "海康威视", DeviceBrandEnum.BRAND_CODE_HIKVISION),
    /**
     * 傲途
     */
    Auto(4L, "傲途", DeviceBrandEnum.BRAND_CODE_AUTO),
    /**
     * 品茗
     */
    PM(5L, "品茗", DeviceBrandEnum.BRAND_CODE_PM),
    /**
     * 华立
     */
    HuaLi(6L, "华立", DeviceBrandEnum.BRAND_CODE_HUA_LI),
    /**
     * 普贝斯
     */
    PBS(7L, "普贝斯", DeviceBrandEnum.BRAND_CODE_PBS),
    /**
     * 西门子
     */
    SIEMENS(8L, "西门子", DeviceBrandEnum.BRAND_CODE_SIEMENS),
    /**
     * 恒安
     */
    HengAn(9L, "恒安", DeviceBrandEnum.BRAND_CODE_HENG_AN),
    /**
     * 建大仁科
     */
    JDRK(10L, "建大仁科", DeviceBrandEnum.BRAND_CODE_JDRK),
    /**
     * 星华
     */
    XingHua(11L, "星华", DeviceBrandEnum.BRAND_CODE_XING_HUA),
    /**
     * 博观
     */
    BoGuan(12L, "博观", DeviceBrandEnum.BRAND_CODE_BO_GUAN),
    /**
     * 威视通
     */
    WeiShiTong(13L, "威视通", DeviceBrandEnum.BRAND_CODE_WEI_SHI_TONG),
    /**
     * 所为
     */
    SuoWei(14L, "所为", DeviceBrandEnum.BRAND_CODE_SUO_WEI),
    /**
     * 保身欣
     */
    BaoShenXin(15L, "保身欣", DeviceBrandEnum.BRAND_CODE_BAO_SHEN_XIN),
    /**
     * 联睿科
     */
    LianRuiKe(16L, "联睿科", DeviceBrandEnum.BRAND_CODE_LIAN_RUI_KE),
    /**
     * 腾屹信
     */
    TengYiXin(17L, "腾屹信", DeviceBrandEnum.BRAND_CODE_TENG_YI_XIN),
    /**
     * 科利特
     */
    KeLiTe(18L, "科利特", DeviceBrandEnum.BRAND_CODE_KE_LI_TE),
    /**
     * 能华泰兴
     */
    NHTX(19L, "能华泰兴", DeviceBrandEnum.BRAND_CODE_NHTX),

    /**
     * 安帕尔
     */
    APE(20L, "安帕尔", DeviceBrandEnum.BRAND_CODE_APE),
    /**
     * 南方测绘
     */
    NFCH(21L, "南方测绘", DeviceBrandEnum.BRAND_CODE_NFCH),
    /**
     * 辰云
     */
    CY(22L, "辰云", DeviceBrandEnum.BRAND_CODE_CY),
    /**
     * 豪恩
     */
    HaoEn(23L, "豪恩", DeviceBrandEnum.BRAND_CODE_HAO_EN),
    /**
     * 拓兴
     */
    TuoXing(24L, "拓兴", DeviceBrandEnum.BRAND_CODE_TUO_XING),
    /**
     * 朗睿
     */
    LangRui(25L, "朗睿", DeviceBrandEnum.BRAND_CODE_LANG_RUI),
    /**
     * 依诺
     */
    YiNuo(26L, "依诺", DeviceBrandEnum.BRAND_CODE_YI_NUO),
    /**
     * 盎锐
     */
    AR(27L, "盎锐", DeviceBrandEnum.BRAND_CODE_AR),
    /**
     * 快鱼
     */
    KuaiYu(28L,"快鱼", DeviceBrandEnum.BRAND_CODE_KUAI_YU),
    /**
     * 涂鸦
     */
    TUYA(29L, "涂鸦", DeviceBrandEnum.BRAND_CODE_TU_YA),
    /**
     * 西力
     */
    XiLi(30L, "西力", DeviceBrandEnum.BRAND_CODE_XI_LI);

    public static final String BRAND_CODE_XIEWEN = "XieWen";
    public static final String BRAND_CODE_XYWG = "XYWG";
    public static final String BRAND_CODE_HIKVISION = "Hikvision";
    public static final String BRAND_CODE_AUTO = "Auto";
    public static final String BRAND_CODE_PM = "PM";
    public static final String BRAND_CODE_HUA_LI = "HuaLi";
    public static final String BRAND_CODE_PBS = "PBS";
    public static final String BRAND_CODE_SIEMENS = "SIEMENS";
    public static final String BRAND_CODE_HENG_AN = "HengAn";
    public static final String BRAND_CODE_JDRK = "JDRK";
    public static final String BRAND_CODE_XING_HUA = "XingHua";
    public static final String BRAND_CODE_BO_GUAN = "BoGuan";
    public static final String BRAND_CODE_WEI_SHI_TONG = "WeiShiTong";
    public static final String BRAND_CODE_SUO_WEI = "SuoWei";
    public static final String BRAND_CODE_BAO_SHEN_XIN = "BaoShenXin";
    public static final String BRAND_CODE_LIAN_RUI_KE = "LianRuiKe";
    public static final String BRAND_CODE_TENG_YI_XIN = "TengYiXin";
    public static final String BRAND_CODE_KE_LI_TE = "KeLiTe";
    public static final String BRAND_CODE_NHTX = "NHTX";
    public static final String BRAND_CODE_APE = "APE";
    public static final String BRAND_CODE_NFCH = "NFCH";
    public static final String BRAND_CODE_CY = "CY";
    public static final String BRAND_CODE_HAO_EN = "HaoEn";
    public static final String BRAND_CODE_TUO_XING = "TuoXing";
    public static final String BRAND_CODE_LANG_RUI = "LangRui";
    public static final String BRAND_CODE_YI_NUO = "YiNuo";
    public static final String BRAND_CODE_AR = "AR";
    public static final String BRAND_CODE_KUAI_YU = "KuaiYu";
    public static final String BRAND_CODE_TU_YA = "TuYa";
    public static final String BRAND_CODE_XI_LI = "XiLi";

    private final Long phid;

    private final String brandName;

    private final String brandCode;

    DeviceBrandEnum(Long phid, String brandName, String brandCode) {
        this.phid = phid;
        this.brandName = brandName;
        this.brandCode = brandCode;
    }

    public static String getBrandCodeById(Long id) {
        for (DeviceBrandEnum ele : values()) {
            if (ele.getPhid().equals(id)) {
                return ele.getBrandCode();
            }
        }
        return null;
    }

}
