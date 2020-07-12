package revolt.backend.mapper;
//переведення полів
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.SignInFormDto;
import revolt.backend.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SignInFormMapper {

    SignInFormDto toDto(User user);

    User toEntity(SignInFormDto signInFormDTO);

    List<SignInFormDto> toDtoList(List<User> users);

    List<User> toEntityList(List<SignInFormDto> signInFormDtos);
}
