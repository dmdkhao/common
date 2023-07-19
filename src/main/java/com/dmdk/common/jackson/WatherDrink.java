package com.dmdk.common.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatherDrink extends AbstractDrink implements IDrink{

    private double temperature;

    @Override
    public DrinkType getDrinkType() {
        return DrinkType.WATER;
    }
}
