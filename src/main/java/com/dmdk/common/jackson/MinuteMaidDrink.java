package com.dmdk.common.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinuteMaidDrink extends AbstractDrink implements IDrink{

    private double sugar;

    @Override
    public DrinkType getDrinkType() {
        return DrinkType.MINUTE_MAID;
    }
}
