package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.enums;

import java.util.Arrays;

public enum EnumScore {
    ONE(1.0),
    TWO(2.0),
    THREE(3.0),
    FOUR(4.0),
    FIVE(5.0);

    private final Double value;
    EnumScore(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public static EnumScore getEnumScore(Double value) {
       return Arrays.stream(EnumScore.values()).filter(x -> x.getValue().equals(value)).findFirst().orElse(null);
    }

}
