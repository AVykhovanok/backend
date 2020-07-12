package revolt.backend.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import revolt.backend.entity.Role;
import revolt.backend.entity.User;
import revolt.backend.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        User user = userServiceImpl.findByLogin(login);
        if (user == null) {
             throw new UsernameNotFoundException("User with login '"
                     + login + "' not found.");
        }

        return UserDetailsImpl.create(user, Role.USER);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userServiceImpl.findById(id);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "Account with id '" + id + "' not found."
            );
        }

        return UserDetailsImpl.create(user, Role.USER);
    }
}