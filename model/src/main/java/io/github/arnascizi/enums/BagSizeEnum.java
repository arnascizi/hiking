package io.github.arnascizi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;

@Getter
@RequiredArgsConstructor
public enum BagSizeEnum {

    SMALL(10D),
    MEDIUM(15D),
    LARGE(25D),
    EXTRA_LARGE(30D);

    private final Double maxWeight;

    public static BagSizeEnum resolveBagSize(String size) {
        return switch (size) {
            case "SMALL" -> BagSizeEnum.SMALL;
            case "MEDIUM" -> BagSizeEnum.MEDIUM;
            case "LARGE" -> BagSizeEnum.LARGE;
            case "EXTRA_LARGE" -> BagSizeEnum.EXTRA_LARGE;
            default -> throw new NotImplementedException("There is no implementation for such bag size: " + size);
        };
    }
}
