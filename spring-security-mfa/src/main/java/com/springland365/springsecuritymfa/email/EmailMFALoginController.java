package com.springland365.springsecuritymfa.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class EmailMFALoginController {

    @Autowired
    UserDetailsManager userDetailsRepo ;

    @Autowired
    PasswordEncoder  passwordEncoder;

    @GetMapping("/email/login")
    public String  emailMFALogin(Model model )
    {

        model.addAttribute("userlogin" , new UserLogin());

        return "email/login.html";
    }

    @PostMapping("/email/login")
    public String emailMFALogin(@ModelAttribute("userlogin") UserLogin login , Model model)
    {


        model.addAttribute("userlogin" , login);
        return "email/login.html";

    }



    @GetMapping("/email/signup")
    public String  emailMFASignup(Model model)
    {

        model.addAttribute("signup" , new Signup());
        return "email/signup.html";
    }

    @PostMapping("/email/signup")
    public RedirectView signup(@ModelAttribute Signup signup)
    {
        log.info(signup.toString());
        userDetailsRepo.createUser(signup.username , passwordEncoder.encode(signup.password) , signup.email);

        return new RedirectView("/email/login") ;
    }



    @GetMapping("/email/code")
    public String emailMFACode(@ModelAttribute("username") String username , @ModelAttribute("password") String password , Model model)
    {
        UserLogin userLogin = UserLogin.builder().username(username).password(password).build();
        model.addAttribute("userlogin" , userLogin);
        return "email/mfacode.html";
    }

    @PostMapping("/email/code")
    public String emailCode(@ModelAttribute  UserLogin userLogin)
    {

        log.info(userLogin.toString());
        return "";
    }

}
