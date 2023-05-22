package io.github.arnascizi.api.controller;

import io.github.arnascizi.api.common.Constant;
import io.github.arnascizi.bl.dto.ItemDto;
import io.github.arnascizi.bl.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.ITEMS_ENDPOINT)
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDto>> listAllItems() {
        return new ResponseEntity<>(itemService.getAllItems(),
                HttpStatus.OK);
    }

    @GetMapping(Constant.SEASON)
    public ResponseEntity<List<ItemDto>> listItemsBySeason(@PathVariable String season) {
        return new ResponseEntity<>(itemService.getItemsBySeason(season.toUpperCase()),
                HttpStatus.OK);
    }
}
