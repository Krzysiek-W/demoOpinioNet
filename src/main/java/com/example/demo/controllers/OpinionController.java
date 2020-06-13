package com.example.demo.controllers;


import com.example.demo.model.Opinion;
import com.example.demo.model.Rate;
import com.example.demo.model.User;
import com.example.demo.repository.OpinionRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@Slf4j
public class OpinionController {

    private final UserRepository userRepository;
    private final OpinionRepository opinionRepository;

    @Autowired
    public OpinionController(UserRepository userRepository, OpinionRepository opinionRepository) {
        this.userRepository = userRepository;
        this.opinionRepository = opinionRepository;
    }


    @GetMapping("/add-opinion")
    public String addOpinionPage() {
        return "/WEB-INF/views/add-new-opinion-page.jsp";
    }

    @PostMapping("/add-opinion")
    public String addOpinion(String opinionAboutPlace, String place, String rate, Principal principal) {
        String userName = principal.getName();
        User user = userRepository.findByUsername(userName);

        Opinion opinion = Opinion.builder()
                .opinionAboutThePlace(opinionAboutPlace)
                .place(place)
                .timeStamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                .rate(Rate.valueOf(rate))
                .reviewer(user)
                .build();

        log.debug("zapsije {}", opinion);

        opinionRepository.save(opinion);

        return "redirect:/";
    }

}
