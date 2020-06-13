package com.example.demo.controllers.access;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.demo.model.Privilege.USER;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String prepareRegistrationPage() {
        return "/WEB-INF/views/registryForm.jsp";
    }


    @PostMapping
    public String processRegistrationPage(String username, String password, String firstName, String lastName) {

        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .firstName(firstName)
                .lastName(lastName)
                .active(true)
                .privilege(USER)
                .build();

        log.debug("Użytkownik do rejestracji : {}", user);

        userRepository.save(user);

        log.debug("Uzytkownik dodany do bazy dynaych : {}",user);

        return "redirect:/";
    }


}
