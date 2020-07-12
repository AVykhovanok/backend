package revolt.backend.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import revolt.backend.entity.User;
import revolt.backend.repository.UserRepository;
import revolt.backend.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findByLogin(String login) {
        Optional<User> user = repository.findByLogin(login);
        return user.orElse(null);
    }

    @Override
    public boolean loginExists(String login) {
        return repository.existsByLogin(login);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public User createUser(User user) {
        user.setId(0L);
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException();
        }
        return repository.save(user);
    }
}