package revolt.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.annotations.CurrentUser;
import revolt.backend.dto.UserDto;
import revolt.backend.entity.User;
import revolt.backend.mapper.UserMapper;
import revolt.backend.repository.UserRepository;
import revolt.backend.security.UserDetailsImpl;
import revolt.backend.service.serviceImpl.UserServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserMapper userMapper;
    private UserServiceImpl userServiceImpl;
    private UserRepository userRepository;


    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(userMapper
                .toDtoList(userServiceImpl.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(userMapper.toDto(userServiceImpl.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<UserDto> getByLogin(@PathVariable String login) {
        return new ResponseEntity<>(userMapper
                .toDto(userServiceImpl.findByLogin(login)), HttpStatus.OK);
    }

    @GetMapping("/exists/login/{login}")
    public ResponseEntity<Boolean> loginExists(@PathVariable String login) {
        return new ResponseEntity<>(userServiceImpl.loginExists(login), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDTO) {
        User user = userServiceImpl.createUser(userMapper.toEntity(userDTO));
        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDTO) {
        User user = userServiceImpl.update(userMapper.toEntity(userDTO));
        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        userServiceImpl.deleteById(id);
    }

    @GetMapping("/me")
    public UserDto getCurrentUser(@CurrentUser UserDetailsImpl userDetailsImpl) {
        return userMapper.toDto(userRepository.findById(userDetailsImpl.getId()).get());
    }
}