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

    @GetMapping("/configurator.html")
    public String configurator() { return "configurator"; }

    @GetMapping("/overview.html")
    public String overview() { return "overview"; }
}
