package pl.edu.agh.to1.aircraftfactoryconfigurator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}