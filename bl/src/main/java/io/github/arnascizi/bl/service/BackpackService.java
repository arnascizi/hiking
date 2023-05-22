package io.github.arnascizi.bl.service;

import io.github.arnascizi.bl.dto.BackpackDto;
import io.github.arnascizi.bl.repository.BackpackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BackpackService {

    private final BackpackRepository backpackRepository;

    public List<BackpackDto> getAllBackpacks() {
        return backpackRepository.getAllBackpacks().stream()
                .map(BackpackDto::of)
                .collect(Collectors.toList());
    }
}
