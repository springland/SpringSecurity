package com.springland365.springsecuritymfa.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class EmailMVCController {

    @Autowired
    UserDetailsRepo  userDetailsRepo ;

    @Autowired
    PasswordEncoder  passwordEncoder;
    @GetMapping("/email")
    public String emailMFCWelcome()
    {
        return "email/index";
    }


    @GetMapping("/email/login")
    public String  emailMFALogin()
    {
        return "email/login.html";
    }


    @GetMapping("/email/signup")
    public String  emailMFASignup(Model model)
    {

        model.addAttribute("signup" , new Signup());
        return "email/signup.html";
    }

    @GetMapping("email/code")
    public String emailMFACode()
    {
        return "email/mfacode.html";
    }


    @PostMapping("/email/signup")
    public String signup(@ModelAttribute Signup signup)
    {
        log.info(signup.toString());
        userDetailsRepo.createUser(signup.username , passwordEncoder.encode(signup.password) , signup.email);
        return "email/login";
    }

}
