package revolt.backend.controller;
//приймає дто з фронту..
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revolt.backend.dto.SignInFormDto;
import revolt.backend.dto.SignUpFormDto;
import revolt.backend.entity.User;
import revolt.backend.mapper.SignInFormMapper;
import revolt.backend.mapper.SignUpFormMapper;
import revolt.backend.security.AuthenticationConstant;
import revolt.backend.service.serviceImpl.AuthenticationServiceImpl;
import revolt.backend.service.serviceImpl.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthenticationController {

    @Value("${app.cookieExpirationInS}")
    private int cookieExpiration;

    private AuthenticationServiceImpl authenticationService;

    private UserServiceImpl userServiceImpl;

    private SignInFormMapper signInFormMapper;

    private SignUpFormMapper signUpFormMapper;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authenticationService,
                                    UserServiceImpl userServiceImpl, SignInFormMapper signInFormMapper, SignUpFormMapper signUpFormMapper) {
        this.authenticationService = authenticationService;
        this.userServiceImpl = userServiceImpl;
        this.signInFormMapper = signInFormMapper;
        this.signUpFormMapper = signUpFormMapper;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(HttpServletResponse response,
                                              @Valid @RequestBody SignInFormDto signInFormDTO) {
        User user = signInFormMapper.toEntity(signInFormDTO);
        String token = authenticationService.login(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(AuthenticationConstant
                .AUTHENTICATION_TOKEN_HEADER, token);
        response.addCookie(createCookie(token));
        //this should only add headers and redirect,
        // but we don't have a page for redirection
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(token);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(HttpServletResponse response,
                                          @Valid @RequestBody SignUpFormDto signUpFormDTO)
            throws Exception {

        User user = signUpFormMapper.toEntity(signUpFormDTO);


        String token = authenticationService.register(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(AuthenticationConstant
                .AUTHENTICATION_TOKEN_HEADER, token);
        response.addCookie(createCookie(token));
        //this should only add headers and redirect,
        // but we don't have a page for redirection
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(token);
    }

    private Cookie createCookie(String token) {
        final Cookie cookie = new Cookie(AuthenticationConstant
                .AUTHENTICATION_TOKEN_HEADER, token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(cookieExpiration);
        return cookie;
    }
}