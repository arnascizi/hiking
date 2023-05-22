package io.github.arnascizi.bl.service;

import io.github.arnascizi.bl.dto.TripDto;
import io.github.arnascizi.bl.payload.TripRequest;
import io.github.arnascizi.bl.repository.ItemRepository;
import io.github.arnascizi.bl.repository.TripRepository;
import io.github.arnascizi.enums.BagSizeEnum;
import io.github.arnascizi.enums.SeasonEnum;
import io.github.arnascizi.model.Backpack;
import io.github.arnascizi.model.Item;
import io.github.arnascizi.model.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final ItemRepository itemRepository;

    // TODO Refactor logic
    public TripDto evaluateItemsForTrip(TripRequest request) {
            Backpack bag = new Backpack();
            bag.setSize(resolveBagSize(request.getTripLength()));
            List<Item> itemsForTrip = itemRepository.getItemsBySeason(
                    SeasonEnum.resolveSeasonFromDate(request.getTravelDate()).name());
            bag.setItemList(itemsForTrip);
            Double weight = 0D;
            for (Item item: itemsForTrip) {
                weight += item.getWeight();
            }
            bag.setCurrentWeight(weight);

            Trip trip = new Trip();
            trip.setSeason(SeasonEnum.resolveSeasonFromDate(request.getTravelDate()).name());
            trip.setDistance(request.getTripLength());
            trip.setBackpack(bag);

            tripRepository.save(trip);

        return TripDto.of(tripRepository.getTrip(trip));
    }

    private String resolveBagSize(Integer tripLength) {
        if (tripLength < 20) {
            return BagSizeEnum.SMALL.name();
        } else if (tripLength > 20 && tripLength < 30) {
            return BagSizeEnum.MEDIUM.name();
        } else if (tripLength > 40 && tripLength < 60) {
            return BagSizeEnum.LARGE.name();
        } else {
            return BagSizeEnum.EXTRA_LARGE.name();
        }
    }
}
