package com.springland365.springsecuritymfa;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityMfaMVCController {

    @GetMapping("/")
    public String home()
    {
        return "/index.html";
    }
}
