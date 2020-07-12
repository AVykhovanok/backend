package revolt.backend.service;

import revolt.backend.dto.ComplectsDto;

import java.util.List;

public interface ComplectsService {

    List<ComplectsDto> getComplectss();

    ComplectsDto createComplects(ComplectsDto complectsDto);

    ComplectsDto getComplects(Long id);

    ComplectsDto updateComplects(ComplectsDto complectsDto, Long complectsId);

    void deleteComplects(Long id);
}
