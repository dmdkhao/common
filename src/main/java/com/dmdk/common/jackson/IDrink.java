package com.dmdk.common.jackson;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * JsonTypeInfo： json类型信息
 *      * use:使用什么作为依据，这里选择JsonTypeInfo.Id.NAME，含义为将字段的名称作为依据
 *      * include
 *      * property：只有当use为NAME或include为PROPERTY才会匹配这个值，含义为json字符串或json对象中的key。（与接收对象实体中定义的参数无关）
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "typeInJson"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CocaDrink.class, name = "COCA"),
        @JsonSubTypes.Type(value = WatherDrink.class, name = "WATER"),
        @JsonSubTypes.Type(value = PepsiDrink.class, name = "PEPSI"),
        @JsonSubTypes.Type(value = MinuteMaidDrink.class, name = "MINUTE_MAID")
})
public interface IDrink extends Serializable {

    DrinkType getDrinkType();

}
