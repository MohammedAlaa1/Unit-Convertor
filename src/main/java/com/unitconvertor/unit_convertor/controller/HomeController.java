package com.unitconvertor.unit_convertor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index.html"; // Ensure index.html is in the right place
    }
}
