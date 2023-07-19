package com.dmdk.common.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CocaDrink extends AbstractDrink implements IDrink{

    private String color;
    private double co2;

    @Override
    public DrinkType getDrinkType() {
        return DrinkType.COCA;
    }
}
