package revolt.backend.service;
//
import revolt.backend.entity.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);

    boolean loginExists(String login);

    List<User> findAll();

    User findById(Long id);

    void deleteById(Long id);

    User createUser(User user);

    User update(User user);
}
