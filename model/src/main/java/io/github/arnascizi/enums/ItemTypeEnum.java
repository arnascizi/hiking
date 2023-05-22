package io.github.arnascizi.enums;

import org.apache.commons.lang3.NotImplementedException;

public enum ItemTypeEnum {

    CONSUMABLE,
    UTILITY,
    FIRST_AID,
    CLOTHING,
    OTHER;

    public static ItemTypeEnum resolveType(String type) {
        return switch (type) {
            case "CONSUMABLE" -> ItemTypeEnum.CONSUMABLE;
            case "UTILITY" -> ItemTypeEnum.UTILITY;
            case "FIRST_AID" -> ItemTypeEnum.FIRST_AID;
            case "CLOTHING" -> ItemTypeEnum.CLOTHING;
            case "OTHER" -> ItemTypeEnum.OTHER;
            default -> throw new NotImplementedException("There is no implementation for such type: " + type);
        };
    }
}
