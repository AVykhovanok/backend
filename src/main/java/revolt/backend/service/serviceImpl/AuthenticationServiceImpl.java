package revolt.backend.service.serviceImpl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import revolt.backend.entity.Role;
import revolt.backend.entity.User;
import revolt.backend.security.JwtTokenProvider;

import javax.naming.AuthenticationException;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationServiceImpl {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider tokenProvider;
    private UserServiceImpl userServiceImpl;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                                     JwtTokenProvider tokenProvider,
                                     UserServiceImpl userServiceImpl,
                                     PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userServiceImpl = userServiceImpl;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(User user) {
        return authenticate(user.getLogin(), user.getPassword());
    }

    public String register(User user)
            throws AuthenticationException {
        try {

            String login = user.getLogin();
            String password = user.getPassword();
            if (userServiceImpl.loginExists(login)) {
                throw new AuthenticationException("User login already in use!");
            }

            user.setPassword(passwordEncoder.encode(password));
            user.setRole(Role.USER);
            userServiceImpl.createUser(user);

            return authenticate(login, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String authenticate(String login, String password) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        login, password
                );

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        return "Bearer " + jwt;
    }
}