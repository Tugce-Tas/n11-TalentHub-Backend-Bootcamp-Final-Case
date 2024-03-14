package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CommentScoreConverter implements AttributeConverter<EnumScore, Double> {

    @Override
    public Double convertToDatabaseColumn(EnumScore attribute) {
        if (attribute == null)
            return 0.0;

        return attribute.getValue();
    }

    @Override
    public EnumScore convertToEntityAttribute(Double dbData) {
        return EnumScore.getEnumScore(dbData);
    }
}
