package revolt.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import revolt.backend.dto.UserDto;
import revolt.backend.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDTO);

    List<UserDto> toDtoList(List<User> users);

    List<User> toEntityList(List<UserDto> userDtos);
}