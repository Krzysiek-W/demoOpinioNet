package com.example.demo.controllers;

import com.example.demo.model.Opinion;
import com.example.demo.repository.OpinionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomePageController {

    private final OpinionRepository opinionRepository;

    @GetMapping
    public String prepareHomePage(Model model) {
        List<Opinion> allOpinions = opinionRepository.findAllByOrderByTimeStamp();
        model.addAttribute("Opinions", allOpinions);
        return "/WEB-INF/views/homePage.jsp";
    }
}
