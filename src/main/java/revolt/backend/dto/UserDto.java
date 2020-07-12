package revolt.backend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    Long id;

    String login;

    String password;

    String firstName;

    String lastName;
    
    String email;
    
    String about;

    String role;

}