package io.github.arnascizi.bl.service;

import io.github.arnascizi.bl.dto.ItemDto;
import io.github.arnascizi.bl.repository.BackpackRepository;
import io.github.arnascizi.bl.repository.ItemRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemDto> getAllItems() {
        return itemRepository.getAllItems().stream()
                .map(ItemDto::of)
                .collect(Collectors.toList());
    }

    public List<ItemDto> getItemsBySeason(@NonNull String season) {
        return itemRepository.getItemsBySeason(season).stream()
                .map(ItemDto::of)
                .collect(Collectors.toList());
    }
}
