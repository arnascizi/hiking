package io.github.arnascizi.bl.dto;

import io.github.arnascizi.enums.ItemTypeEnum;
import io.github.arnascizi.enums.SeasonEnum;
import io.github.arnascizi.model.Item;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long id;
    private String name;
    private ItemTypeEnum type;
    private Integer quantity;
    private Double weight;
    private SeasonEnum recommendedSeason;

    public static ItemDto of(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .type(ItemTypeEnum.resolveType(item.getType()))
                .quantity(item.getQuantity())
                .weight(item.getWeight())
                .recommendedSeason(SeasonEnum.resolveSeason(item.getRecommendedSeason()))
                .build();
    }
}
