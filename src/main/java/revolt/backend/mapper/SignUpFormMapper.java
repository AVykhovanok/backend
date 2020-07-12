package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.SignUpFormDto;
import revolt.backend.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SignUpFormMapper {

    SignUpFormDto toDto(User user);

    User toEntity(SignUpFormDto signUpFormDTO);

    List<SignUpFormDto> toDtoList(List<User> users);

    List<User> toEntityList(List<SignUpFormDto> signUpFormDtos);
}
