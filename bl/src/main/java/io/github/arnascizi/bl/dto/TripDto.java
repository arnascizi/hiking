package io.github.arnascizi.bl.dto;

import io.github.arnascizi.enums.SeasonEnum;
import io.github.arnascizi.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private Long id;
    private Integer distance;
    private SeasonEnum season;
    private BackpackDto backpackDto;

    public static TripDto of(Trip trip) {
        return TripDto.builder()
                .id(trip.getId())
                .distance(trip.getDistance())
                .season(SeasonEnum.resolveSeason(trip.getSeason()))
                .backpackDto(BackpackDto.of(trip.getBackpack()))
                .build();
    }
}
