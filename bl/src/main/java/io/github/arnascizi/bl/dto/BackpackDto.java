package io.github.arnascizi.bl.dto;

import io.github.arnascizi.enums.BagSizeEnum;
import io.github.arnascizi.model.Backpack;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BackpackDto {

    private Long id;
    private BagSizeEnum size;
    private Double currentWeight;
    private List<ItemDto> itemList;

    public static BackpackDto of(Backpack pack) {
        return BackpackDto.builder()
                .id(pack.getId())
                .size(BagSizeEnum.resolveBagSize(pack.getSize()))
                .currentWeight(pack.getCurrentWeight())
                .itemList(pack.getItemList().stream()
                        .map(ItemDto::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
