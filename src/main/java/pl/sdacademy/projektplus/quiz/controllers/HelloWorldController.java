package pl.sdacademy.projektplus.quiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("message", "some message");

        return "index";
    }
}
